db.users.find();

db.users.insert({ username: 'smith' });
db.users.find() // find에 매개변수가 없음 -> 전부 다 보여주기

use totorial; //tutorial database가 자동으로 만들어짐
db.tutorial.insert({ username: 'smith' });

db.users.insert({ username: 'jones' });
db.users.find()
db.users.count();
// PK는 자동으로 _id (모든 도큐먼트에 반드시 존재하는 _id)
// _id는 ObjectId로 관리됨. 괄호 안에 16진수로 표현된 문자열이 있음. 실제 id인 것 = UUID(Universally Unique ID)



db.users.find({username: "jones"});
db.users.find({$or:
[{username: "jones"}, {username: "smith"}]});
db.users.find({_id : ObjectId("669dbcace087b396cc072f8d"), username: "jones"} );


// -------
db.users.update({username: "smith"}, {$set: {country: "Canada"}});
db.users.find();

// -------
db.users.replaceOne({username: "smith"}, {country: "Canada"});
db.users.find();

db.users.replaceOne({country: "Canada"}, {username: "smith", country:"Canada"});
db.users.find();


// -------
db.users.update({username: "smith"}, {$unset: {country: "Canada"}});
db.users.find();

// ---------
show dbs;
show collections;
db.status;
db.users.status;

// --------
db.users.remove({username: "smith"});
db.users.find();

db.users.remove({});
db.users.find();

db.users.drop();

show dbs;
show collections;