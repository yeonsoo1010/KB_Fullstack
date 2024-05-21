var a = 10; //전역변수

(function (){
    var b = 20; //지역변수
}) (); //()로 함수 call

console.log(a); //10
console.log(b); //b is not defined