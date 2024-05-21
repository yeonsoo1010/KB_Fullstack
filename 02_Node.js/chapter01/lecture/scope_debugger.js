var x = 0;
{
  var x = 1;
  console.log(x); //1
}
console.log(x); //1

let y = 0;
{
  let y = 1;
  console.log(y); //1
}
console.log(y); //0
