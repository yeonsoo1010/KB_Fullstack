package ch07.sec04.exam02;

public class SupersonicAirplaneExample {
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff();
        sa.fly(); // normal일 때니까 일반비행으로 뜰 것 같음.
        sa.flyMode = SupersonicAirplane.SUPERSONIC;
        sa.fly(); // 초음속 비행
        sa.flyMode = SupersonicAirplane.NORMAL;
        sa.fly(); // 일반 비행
        sa.land();
    }
}
