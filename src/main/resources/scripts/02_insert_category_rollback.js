const {MongoClient} = require('mongodb');

async function main() {
    const uri = 'mongodb://localhost:27017'; // MongoDB bağlantı URI'si
    const client = new MongoClient(uri);

    try {
        await client.connect(); // MongoDB'ye bağlan

        const database = client.db('test'); // Veritabanı adınıza göre değiştirin
        const collection = database.collection('category'); // Koleksiyon adınıza göre değiştirin

        // Eklenen verileri geri almak için koleksiyondan tüm verileri kaldıralım
        await collection.deleteMany({});

        console.log('Categories removed successfully!');
    } finally {
        await client.close(); // MongoDB bağlantısını kapat
    }
}

main().catch(console.error);