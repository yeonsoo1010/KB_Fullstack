package ch06.sec07.exam04;

public class CarExample {
    public static void main(String[] args) {
        // 객체 1: car1 by 디폴트 생성자
        Car car1 = new Car();

        System.out.println("car1.company: "+ car1.company);
        // 입력하지 않은 값은 모두 초기값으로 들어간다!
//        System.out.println("car1.model: "+ car1.model);
//        System.out.println("car1.color: "+ car1.color);
//        System.out.println("car1.maxSpeed: "+ car1.maxSpeed);
        System.out.println();

        // 객체 2: car2 by model 매개변수 생성자
        Car car2 = new Car("자가용");

        System.out.println("car2.company: "+ car2.company);
        System.out.println("car2.model: "+ car2.model);
//        System.out.println("car2.color: "+ car2.color);
//        System.out.println("car2.maxSpeed: "+ car2.maxSpeed);
        System.out.println();

        // 객체 3: car3 by model, color 매개변수 생성자
        Car car3 = new Car("자가용", "빨강");

        System.out.println("car3.company: "+ car3.company);
        System.out.println("car3.model: "+ car3.model);
        System.out.println("car3.color: "+ car3.color);
//        System.out.println("car3.maxSpeed: "+ car3.maxSpeed);
        System.out.println();

        // 객체 4: car4 by model, color, maxSpeed 매개변수 생성자
        Car car4 = new Car("택시", "검정", 200);

        System.out.println("car4.company: "+ car4.company);
        System.out.println("car4.model: "+ car4.model);
        System.out.println("car4.color: "+ car4.color);
        System.out.println("car4.maxSpeed: "+ car4.maxSpeed);
    }
}
