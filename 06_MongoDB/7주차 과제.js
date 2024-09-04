use test;

// db.product.remove({});
for (let i=0; i<20000; i++) {
    db.product.insert({num: i, name: "스마트폰 " + i});
}
db.product.find();

db.product.count();

// --------------

db.product.find().sort({num: -1});

db.product.find().sort({num: -1}).limit(10);

for (let i=1; i<=6; i++) {
    pageNum = i;
    db.product.find().sort({num: -1}).skip((pageNum -1) *10).limit(10);
}

pageNum = 6;
db.product.find().sort({num: -1}).skip((pageNum -1) *10).limit(10);

// -----------------

db.product.find({ $or: [
    {num: {$lt: 15}}, 
    {num: {$gt: 19995}}
]});

//db.product.find({ num: 
//    {$or: 
//    [{$lt: 15}, 
//    {$gt: 199995}]
//    }
//}); -----------안됨 



db.product.find({name: {$in: ["스마트폰 10", "스마트폰 100", "스마트폰 1000"]}});
    
    

// ----------------

db.product.find({num: {$lt: 5}}, {name:1, _id:0}) //뒤 매개변수가 projection!!!, _id 0으로 하는 것만 혼용 가능
