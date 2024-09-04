package ch16.sec03;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 매개변수가 2개
        person.action1((name, job) -> {
            System.out.println(name + "이/가 " + job + "을/를 합니다.");
            System.out.println(name + "이/가 " + job + "을/를 하지 않습니다.");
                }
        );

        // 매개변수가 1개
        person.action2((speak) -> {
            System.out.println('"' + speak + "\"이라고 말합니다.");
            System.out.println('"' + speak + "\"이라고 외칩니다.");
                }
        );
    }
}
