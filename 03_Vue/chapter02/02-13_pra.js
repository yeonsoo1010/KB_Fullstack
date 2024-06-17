// let obj = {result:0};

// obj.add = function(x,y) {
//     function inner() {
//         this.result = x+y;
//     }
//     inner();
// }


// obj.add(3,4)

// console.log(obj.result); //0
// console.log(global.result); //7

let obj = { result: 0 };

obj.add = function(x, y) {
    function inner() {
        this.result = x + y;
    }
    inner.call(this); // this를 obj로 설정하여 호출
}

obj.add(3, 4);

console.log(obj.result); // 7
console.log(global.result); // undefined, 전역 객체의 result는 설정되지 않음
