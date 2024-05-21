//동기함수로 파일 읽기 - readFileSync 함수

//fs 모듈 불러오기
const fs = require("fs");

const data = fs.readFileSync("./chapter03/example.txt", "utf-8");
console.log(data);
