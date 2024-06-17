let add = function(x,y) {
    this.result = x+y;
}

let obj = {};

// apply()
add.apply(obj, [3,4]);
console.log(obj);

// call()
add.call(obj, 3,4);
console.log(obj);

// bind()
add_bind = add.bind(obj);
add(3,4);

console.log(obj);