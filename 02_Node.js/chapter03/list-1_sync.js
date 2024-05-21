//fs 모듈 불러오기
const fs = require("fs");

//동기
let files = fs.readdirSync("./");
console.log(files); //chapte01, 02, 03 출력
