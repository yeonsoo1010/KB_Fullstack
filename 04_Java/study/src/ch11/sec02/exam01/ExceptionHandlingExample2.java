package ch11.sec02.exam01;

public class ExceptionHandlingExample2 {
    public static void printLength(String data) {
        // 성공
        try {
            int result = data.length();
            System.out.println("문자 수: " + result);
        }
        // 예외 - NullPointerException이 아닌 모든 Exception이어도 ok.
        catch (NullPointerException e) {
            System.out.println("[에러] NullPointExeception: " + e.toString());
            System.out.println("[에러] NullPointExeception 메시지: " + e.getMessage());
            e.printStackTrace();
        }
        finally { //finally는 예외가 발생하든 안하든 최종적으로 처리되는 로직
            System.out.println("[마무리 실행] \n");
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}

