package ch16.sec04;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 실행문이 2개 이상
        person.action((x,y) -> {
            double result = x + y;
            return result;
        });

        // sum() 메서드 호출
        person.action((x,y) -> {
            return sum(x, y);
        });
        person.action((x,y) -> sum(x,y));
    }

    public static double sum(double x, double y) {
        return (x + y);
    }
}
