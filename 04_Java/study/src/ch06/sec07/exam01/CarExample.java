package ch06.sec07.exam01;

public class CarExample {
    public static void main(String[] args) {

        Car myCar = new Car("그랜저", "검정", 250);
        // Car myCar = new Car();

        System.out.println(myCar);
        System.out.println(myCar.model);
        System.out.println(myCar.color);
        System.out.println(myCar.maxSpeed);
    }
}
