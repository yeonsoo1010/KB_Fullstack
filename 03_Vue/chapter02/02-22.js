let p = new Promise((resolve, reject) => {
    resolve("first")
})

p.then((msg) => {
    console.log(msg);
    return "second"
})

.then((msg) => {
    console.log(msg);
    return "third"
})

.then((msg) => {
    console.log(msg);
})

.catch((error) => {
    console.log("오류발생: "+error);
})