package ch06.sec07.exam04;

public class Car {
    // 필드 선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    // 생성자 선언
    // 매개변수 없는 생성자: 디폴트 생성자
    Car(){}

    // 매개변수가 model인 생성자
    public Car(String model) {
        this.model = model;
    }

    // 매개변수가 model, color인 생성자

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // 매개변수가 model, color, maxSpeed인 생성자
    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
