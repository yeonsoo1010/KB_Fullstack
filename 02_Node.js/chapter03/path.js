const path = require("path");

//경로 결합하기 - join
const fullPath = path.join("some", "work", "ex.txt");
console.log(fullPath);

console.log("-----------------------------------------");

//파일명을 포함한 전체 절대 경로
console.log(`파일 절대 경로: ${__filename}`);

//경로만 추출
const dir = path.dirname(__filename);
console.log(`경로만_path 모듈 써서: ${dir}`);
console.log(`경로만_dirname으로 바로: ${__dirname}`);

console.log("-----------------------------------------");

//파일이름
console.log(`파일 이름: ${path.basename(__filename)}`);

//파일이름 (확장자 제외)
console.log(`파일 이름(확장자 제외): ${path.basename(__filename, ".js")}`);

//확장명
console.log(`확장자: ${path.extname(__filename)}`);

console.log("-----------------------------------------");

//경로 요소 전체
const parsedPath = path.parse(__filename);
console.log(parsedPath);
