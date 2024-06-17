function addContact(name, mobile, home="없음", address="없음", email="없음") {
    let chul = `name=${name}, mobile=${mobile}, home=${home}, address=${address}, email=${email}`
    console.log(chul);
}

addContact("홍길동", "010-0000-0000");