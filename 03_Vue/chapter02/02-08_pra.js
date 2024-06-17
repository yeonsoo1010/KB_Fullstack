function addContact1({name, phone, email="이메일없음", age=0}) {
    console.log(name, phone, email, age);
}

addContact1({name: "연수", phone: "010-0000-0000"})


function addContact2(contact) {
    if(!contact.email) contact.email = "이메일없음";
    if (!contact.age) contact.age = 0;
    let {name, phone, age, email} = contact;
    console.log(name, phone, email, age);
}
addContact2({name: "연수", phone: "010-0000-0000"})


function addContact3(name, phone, email="이메일없음", age=0) {
    console.log(name, phone, email, age);
}
addContact3("연수", "010-0000-0000")