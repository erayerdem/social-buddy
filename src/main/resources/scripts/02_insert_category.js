const {MongoClient} = require('mongodb');

// Ana kategoriler
const mainCategories = [
    {name: "Tiyatro", description: "Tiyatro Etkinlikleri", externalId: 1, icon: "tiyatro_icon", color: "blue"},
    {name: "Müzik", description: "Müzik Etkinlikleri", externalId: 2, icon: "music_icon", color: "yellow"},
    {name: "Haber", description: "Haber Etkinlikleri", externalId: 3, icon: "haber_icon", color: "green"},
    {name: "Psikolog Yazar", description: "Haber Etkinlikleri", externalId: 4, icon: "haber_icon", color: "green"}

];


// Ana işlev
async function main() {
    const uri = 'mongodb://localhost:27017'; // MongoDB bağlantı adresi
    const client = new MongoClient(uri);

    try {
        await client.connect(); // MongoDB'ye bağlan

        const database = client.db('test'); // Veritabanı adınızı değiştirin
        const collection = database.collection('category'); // Koleksiyon adınızı değiştirin

        // Ana kategorileri koleksiyona ekleme
        const mainCategoryIds = await insertCategories(collection, mainCategories);


        console.log("Sample data inserted successfully!");
    } finally {
        await client.close(); // MongoDB bağlantısını kapat
    }
}

// Kategorileri koleksiyona ekleme fonksiyonu
async function insertCategories(collection, categories) {
    const insertedIds = [];
    for (const category of categories) {
        const result = await collection.insertOne(category);
        insertedIds.push(result.insertedId);
    }
    return insertedIds;
}

// Alt kategorileri koleksiyona ekleme fonksiyonu
async function insertSubCategories(collection, subCategories, mainCategoryIds) {
    for (const subCategory of subCategories) {
        // Alt kategorinin parentName'e göre ana kategorisinin _id değerini bulma
        const parentCategoryId = mainCategoryIds.find(id => subCategory.parentName === mainCategories.find(cat => cat._id === id).name);
        // Ana kategorinin _id değerini alt kategoriye atama
        subCategory.parentId = parentCategoryId;

        // Alt kategoriyi koleksiyona ekleme
        await collection.insertOne(subCategory);
    }
}

main().catch(console.error);