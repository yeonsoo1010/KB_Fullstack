// let obj = {result:0};
// obj.add = function(x,y) {
//     this.result = x+y;
//     // result = x+y;
// }

// console.log(`add_obj: ${obj}`);
// console.log(`add_obj.result: ${obj.result}`)

// let add2 = obj.add;

// console.log(add2 === obj.add);

// add2(3,4);
// console.log(`add2_obj: ${obj}`);
// console.log(`add2_obj.result: ${obj.result}`)

let obj = { result: 0 };
obj.add = function(x,y) {  
   this.result = x+y;
}
let add2 = obj.add;
console.log(add2 === obj.add)      //true, 동일한 함수
add2(3,4)       //전역변수 result에 7이 할당됨.
console.log(obj);       //{ result: 0 }
console.log(obj.result); //0
// console.log(window.result);
console.log(global.result);
console.log(result);    //7