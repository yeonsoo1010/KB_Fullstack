package ch06.sec07.exam01;

public class Car {
    // 필드 선언
    String model;
    String color;
    int maxSpeed;

    // 생성자 선언
    Car(String model, String color, int maxSpeed) {
        this.model = model; // 필드 = 매개변수
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}

