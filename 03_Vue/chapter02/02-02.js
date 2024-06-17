let msg = "GLOBAL"; // 전역변수

function outer() {
  let msg = "OUTER";
  console.log(msg); //outer
  if (true) {
    let msg = "BLOCK";
    console.log(msg); //block
  }
  console.log(this.msg); //undefined
  console.log(msg);
}

const Outer = function () {
  let msg = "newOUTER";
  console.log(msg);
};

outer();
Outer();
