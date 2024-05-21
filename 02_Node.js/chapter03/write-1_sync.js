//동기 함수로 파일 작성 - writeFileSync

//fs 모듈 불러오기
fs = require("fs");

const data = fs.readFileSync("./chapter03/example.txt", "utf-8");
fs.writeFileSync("./chapter03/writtenText-1.txt", data);
