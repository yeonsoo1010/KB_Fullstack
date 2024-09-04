package ch08.sec02;

public class RemoteControlExample {
    public static void main(String[] Args) {
        RemoteControl rc;

        // rc 변수에 Television 객체 대입
        rc = new Television();
        rc.TurnOn();

        // rc 변수에 Audio 객체 대입
        rc = new Audio();
        rc.TurnOn();
    }
}
