package ch08.sec08;

public class SmartTelevision implements RemoteControl, Searchable {
    // RemoteControl 인터페이스 메서드 오버라이딩
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }

    // Searchable 인터페이스 메서드 오버라이딩
    @Override
    public void search(String url) {
        System.out.println(url + "을 검색합니다.");
    }
}
