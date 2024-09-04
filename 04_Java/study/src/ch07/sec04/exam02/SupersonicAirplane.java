package ch07.sec04.exam02;

public class SupersonicAirplane extends Airplane {
    // 필드 선언 - 왜 normal, supersonic에 값을 할당해준 것?
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;

    public int flyMode = NORMAL;

    // 메서드 선언 (오버라이드) -> airplane의 메서드들을 모두 가져오고, fly만 덮어씌워서 새로 만드는 것?

    @Override
    public void fly() {
        if(flyMode == SUPERSONIC) {
            System.out.println("초음속 비행합니다.");
        } else {
        super.fly();
        }
    }
}
