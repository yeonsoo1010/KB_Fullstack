package ch12.sec04;

public class MeasureRunTimeExample {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // 합 구하는 프로그램
        int sum = 0;
        for (int i=1; i<=1000000; i++) {
            sum += i;
        }

        long endTime = System.nanoTime();
        long time = endTime - startTime;

        System.out.println("1~1000000까지의 합: " + sum);
        System.out.println(time + " 나노초가 소요되었습니다.");
    }
}
