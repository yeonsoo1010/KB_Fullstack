package ch16.sec03;

public class Person {
    // Workable 인터페이스를 가지는 action1 메소드
    public void action1(Workable workable) {
        workable.work("홍길동", "프로그래밍");
    }

    // Speakable 인터페이스를 가지는 action2 메소드
    public void action2(Speakable speakable) {
        speakable.speak("안뇽하세용");
    }
}
