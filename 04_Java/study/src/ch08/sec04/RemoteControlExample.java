package ch08.sec04;

import java.rmi.Remote;

public class RemoteControlExample {
    public static void main(String[] Args) {
        // 인터페이스 변수 선언
        RemoteControl rc1;
//        RemoteControl rc2;

        // Television 객체 생성하고 인터페이스 변수에 대입
        rc1 = new Television();
        rc1.turnOn();
        rc1.setVolume(5);
        rc1.turnOff();

        // Audio 객체 생성하고 인터페이스 변수에 대입
        Audio rc2 = new Audio();
        rc2.turnOn();
        rc2.setVolume(5);
        rc2.volume = 11;
        System.out.println(rc2.volume);
        rc2.turnOff();
    }
}
