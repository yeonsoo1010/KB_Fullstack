//fs 모듈 불러오기
const fs = require("fs");

//비동기
//readdir(위치, (에러, 성공) => {if(에러) {...} ...})
//콜백함수
fs.readdir("./", (err, files) => {
  if (err) {
    console.error(err);
    // return;
  }
  console.log(files);
});
