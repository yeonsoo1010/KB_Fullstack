package ch08.sec02;

public class Audio implements RemoteControl {
    @Override
    public void TurnOn() {
        System.out.println("Audio를 켭니다.");
    }
}
