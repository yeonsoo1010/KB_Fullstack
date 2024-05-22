let obj = { result: 0 };

obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
    // obj의 result 메서드에 할당한다
    // result = x + y;
  }
  inner();
};
obj.add(3, 4);

console.log(obj);
console.log(result);
