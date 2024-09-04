package ch08.sec08;

public class MultiInterfaceImplExample {
    public static void main(String[] args) {
        // RemoteControl 인터페이스 변수 선언
        RemoteControl rc = new SmartTelevision();

        // Searchable 인터페이스 변수 선언
        Searchable searchable = new SmartTelevision();

        // 객체 대입
        rc.turnOn();
        searchable.search("www.naver.com");
        rc.turnOff();
    }
}
