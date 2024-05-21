//비동기함수로 파일 읽기 - readFile(파일, [옵션], 콜백)

//fs 모듈 불러오기
fs = require("fs");

fs.readFile(".example.txt", "utf-8", (err, data) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(data);
});
