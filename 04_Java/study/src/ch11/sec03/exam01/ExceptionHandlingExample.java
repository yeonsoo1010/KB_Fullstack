package ch11.sec03.exam01;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for (int i = 0; i < array.length; i++) {
            // 성공
            try {
                int value = Integer.parseInt(array[i]); // 문자열 -> 정수형
                System.out.println("array[" + i + "]: " + value);
            }
            // 예외
            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            }
            catch(NumberFormatException e) {
                System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
            }
        }
    }
}
