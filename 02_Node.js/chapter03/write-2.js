//비동기함수로 파일 쓰기 - writeFile

//fs 모듈 불러오기
const fs = require("fs");

const data = fs.readFile("./chapter03/example.txt", "utf-8", (err, data) => {
  if (err) {
    console.error(err);
  }
  //   console.log(data);
  //   return data;

  fs.writeFile("./chapter03/writtenText-21.txt", data, (err) => {
    if (err) {
      console.log(err);
    }
    console.log("text-2.txt is saved!");
  });
});

// console.log(data); //undefined
