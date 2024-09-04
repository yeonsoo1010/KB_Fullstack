package ch11.sec02.exam01;

// 문제점:
// printLength(null)에서
// String data를 인수로 받아야 하지만, data가 비어 있어(null)
// NullPointerException이 발생함.
// 매개값으로 null을 받아온 거까지는 ok, but data.length()를 처리하는 과정(메소드 접근)에서 예외가 생김.
// 실행은 가능!

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        int result = data.length();
        System.out.println("문자 수: " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}
