function Person(name, gender) {
  this.name = name;
  this.gender = gender;
  this.sayHello = function () {
    console.log("Hi! my name is " + this.name);
  };
}

var foo = new Person("Lee", "male");

console.dir(Person);
console.dir(foo);

console.log(foo.__proto__ === Person.prototype); // ① true
console.log(Person.prototype.__proto__ === Object.prototype); // ② true
console.log(Person.prototype.constructor === Person); // ③ true
console.log(Person.__proto__ === Function.prototype); // ④ true
console.log(Function.prototype.__proto__ === Object.prototype); // ⑤ true
