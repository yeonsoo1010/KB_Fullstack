//fs 모듈 불러오기
fs = require("fs");

//존재하는 파일인지 확인 - existsSync
//파일 있으면 존재한다고 출력
const data = fs.readFile("./chapter03/example.txt", "utf-8", (err, data) => {
  if (err) {
    console.log("오류1: 읽어들이지 못했습니다");
    return;
  }

  //읽었으면 파일 생성하기
  //새로 쓸 파일이 이미 있으면 끝내기
  if (fs.existsSync("./chapter03/writtenText-3.txt")) {
    console.log("오류2: 새로 생성할 파일이 이미 존재합니다");
  } else {
    fs.writeFile("./chapter03/writtenText-3.txt", data, (err) => {
      if (err) {
        console.log("오류3: 새로운 파일 생성에서 문제가 생겼습니다");
      }
      console.log("[성공] 새로운 파일 생성을 마쳤습니다");
    });
  }
});
