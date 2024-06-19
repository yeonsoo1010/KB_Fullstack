package ch06.sec07.exam02;

public class Korean {
    // 필드 선언
    String nation = "대한민국";
    String name;
    String ssn ;

    // 생성자 선언
    public Korean(String name, String ssn) {
        // this.nation = nation; - nation은 인수로 받지 않음.
        this.name = name;
        this.ssn = ssn;
    }
}
