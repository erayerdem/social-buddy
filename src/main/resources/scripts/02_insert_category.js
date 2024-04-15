const {MongoClient} = require('mongodb');

// Ana kategoriler
const mainCategories = [
    {name: "Music", description: "Music events", icon: "music_icon", color: "blue"},
    {name: "Art", description: "Art events", icon: "art_icon", color: "yellow"},
    {name: "Sport", description: "Sport events", icon: "sport_icon", color: "green"}
];

// Alt kategoriler
const subCategories = [
    {name: "Rock", description: "Rock music events", icon: "rock_icon", color: "black", parentName: "Music"},
    {name: "Pop", description: "Pop music events", icon: "pop_icon", color: "pink", parentName: "Music"},
    {name: "Painting", description: "Painting events", icon: "painting_icon", color: "orange", parentName: "Art"},
    {name: "Sculpture", description: "Sculpture events", icon: "sculpture_icon", color: "gray", parentName: "Art"},
    {name: "Football", description: "Football events", icon: "football_icon", color: "red", parentName: "Sport"},
    {name: "Basketball", description: "Basketball events", icon: "basketball_icon", color: "blue", parentName: "Sport"}
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

        // Ana kategorilerin _id değerlerini kullanarak alt kategorileri koleksiyona ekleme
        await insertSubCategories(collection, subCategories, mainCategoryIds);

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