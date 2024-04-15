const {MongoClient} = require('mongodb');

async function main() {

    const turkishCities = [
        {name: 'Adana', plateNumber: 1, popularity: 7},
        {name: 'Adıyaman', plateNumber: 2},
        {name: 'Afyonkarahisar', plateNumber: 3},
        {name: 'Ağrı', plateNumber: 4},
        {name: 'Amasya', plateNumber: 5},
        {name: 'Ankara', plateNumber: 6, popularity: 9},
        {name: 'Antalya', plateNumber: 7, popularity: 8},
        {name: 'Artvin', plateNumber: 8},
        {name: 'Aydın', plateNumber: 9},
        {name: 'Balıkesir', plateNumber: 10},
        {name: 'Bilecik', plateNumber: 11},
        {name: 'Bingöl', plateNumber: 12},
        {name: 'Bitlis', plateNumber: 13},
        {name: 'Bolu', plateNumber: 14},
        {name: 'Burdur', plateNumber: 15},
        {name: 'Bursa', plateNumber: 16},
        {name: 'Çanakkale', plateNumber: 17},
        {name: 'Çankırı', plateNumber: 18},
        {name: 'Çorum', plateNumber: 19},
        {name: 'Denizli', plateNumber: 20},
        {name: 'Diyarbakır', plateNumber: 21},
        {name: 'Edirne', plateNumber: 22},
        {name: 'Elazığ', plateNumber: 23},
        {name: 'Erzincan', plateNumber: 24},
        {name: 'Erzurum', plateNumber: 25},
        {name: 'Eskişehir', plateNumber: 26},
        {name: 'Gaziantep', plateNumber: 27},
        {name: 'Giresun', plateNumber: 28},
        {name: 'Gümüşhane', plateNumber: 29},
        {name: 'Hakkâri', plateNumber: 30},
        {name: 'Hatay', plateNumber: 31},
        {name: 'Isparta', plateNumber: 32},
        {name: 'Mersin', plateNumber: 33},
        {name: 'İstanbul', plateNumber: 34, popularity: 10},
        {name: 'İzmir', plateNumber: 35, popularity: 9},
        {name: 'Kars', plateNumber: 36},
        {name: 'Kastamonu', plateNumber: 37},
        {name: 'Kayseri', plateNumber: 38},
        {name: 'Kırklareli', plateNumber: 39},
        {name: 'Kırşehir', plateNumber: 40},
        {name: 'Kocaeli', plateNumber: 41},
        {name: 'Konya', plateNumber: 42},
        {name: 'Kütahya', plateNumber: 43},
        {name: 'Malatya', plateNumber: 44},
        {name: 'Manisa', plateNumber: 45},
        {name: 'Kahramanmaraş', plateNumber: 46},
        {name: 'Mardin', plateNumber: 47},
        {name: 'Muğla', plateNumber: 48},
        {name: 'Muş', plateNumber: 49},
        {name: 'Nevşehir', plateNumber: 50},
        {name: 'Niğde', plateNumber: 51},
        {name: 'Ordu', plateNumber: 52},
        {name: 'Rize', plateNumber: 53},
        {name: 'Sakarya', plateNumber: 54},
        {name: 'Samsun', plateNumber: 55},
        {name: 'Siirt', plateNumber: 56},
        {name: 'Sinop', plateNumber: 57},
        {name: 'Sivas', plateNumber: 58},
        {name: 'Tekirdağ', plateNumber: 59},
        {name: 'Tokat', plateNumber: 60},
        {name: 'Trabzon', plateNumber: 61},
        {name: 'Tunceli', plateNumber: 62},
        {name: 'Şanlıurfa', plateNumber: 63},
        {name: 'Uşak', plateNumber: 64},
        {name: 'Van', plateNumber: 65},
        {name: 'Yozgat', plateNumber: 66},
        {name: 'Zonguldak', plateNumber: 67},
        {name: 'Aksaray', plateNumber: 68},
        {name: 'Bayburt', plateNumber: 69},
        {name: 'Karaman', plateNumber: 70},
        {name: 'Kırıkkale', plateNumber: 71},
        {name: 'Batman', plateNumber: 72},
        {name: 'Şırnak', plateNumber: 73},
        {name: 'Bartın', plateNumber: 74},
        {name: 'Ardahan', plateNumber: 75},
        {name: 'Iğdır', plateNumber: 76},
        {name: 'Yalova', plateNumber: 77},
        {name: 'Karabük', plateNumber: 78},
        {name: 'Kilis', plateNumber: 79},
        {name: 'Osmaniye', plateNumber: 80},
        {name: 'Düzce', plateNumber: 81}
    ];

    const uri = 'mongodb://localhost:27017'; // MongoDB bağlantı URI'si
    const client = new MongoClient(uri);

    try {
        await client.connect();
        const database = client.db('test');
        const collection = database.collection('city');
        await collection.insertMany(turkishCities);

        console.log('Turkish cities inserted successfully!');
    } finally {
        await client.close(); // MongoDB bağlantısını kapat
    }
}

main().catch(console.error);
