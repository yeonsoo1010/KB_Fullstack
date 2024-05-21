//fs 모듈 불러오기
fs = require("fs");

//fs.mkdir 이용하기
//디렉토리 있으면
if (fs.existsSync("./test")) {
  console.log("폴더가 이미 존재합니다");
  return;
}
//디렉토리 없으면 생성
fs.mkdir("./test", (err) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log("폴더를 새로 생성했습니다");
});
