//fs 모듈 불러오기
fs = require("fs");

//폴더 만들기: fs.mkdir()
//있는지 확인하기: fs.existsSync()

if (fs.existsSync("./test2/test3/test4")) {
  console.log("해당 디렉토리가 이미 존재합니다");
  return;
}
fs.mkdir("./test2/test3/test4", { recursive: true }, (err) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log("디렉토리를 새로 생성했습니다");
});
