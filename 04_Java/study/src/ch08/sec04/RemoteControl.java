package ch08.sec04;

public interface RemoteControl {
    // 필드 선언 - 상수로 !
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    // 추상 메소드 - public은 생략되어 있음
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}
