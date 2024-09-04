package CLI_Framework.V1;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 필드 선언
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;

        // Scanner 불러오기
        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("--------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("--------------------------------");
            System.out.println("선택: ");

            // 입력값 받기
            int selectNo = Integer.parseInt(scanner.nextLine());

            if (selectNo == 1) {
                // 받은 학생 수만큼, scores 배열 크기 정하기
                System.out.println("학생수> ");
                studentNum = Integer.parseInt(scanner.nextLine());
                scores = new int[studentNum];
            }

            else if (selectNo == 2) {
                // scores 배열에 입력받은 점수들 집어넣기
                for (int i = 0; i < scores.length; i++) {
                    // System.out.println("scores[" + i + "]> " + scores[i]);
                    System.out.println("scores[" + i + "]> ");
                    scores[i] = Integer.parseInt(scanner.nextLine());
                }
            }
            else if (selectNo == 3) {
                // scores 배열 전체 출력하기
                for (int i = 0; i < scores.length; i++) {
                    System.out.println("scores[" + i + "]> " + scores[i]);
                }
            }
            else if (selectNo == 4) {
                int max = 0;
                int sum = 0;
                double avg = 0;

                // 배열 돌면서 max 업데이트하기
                for (int i = 0; i < scores.length; i++) {
                    max = (scores[i]>max) ? scores[i] : max;
                    sum += scores[i];
                }
                avg = (double)sum / studentNum; // 형변환
                System.out.println("최고 점수: " + max);
                System.out.println("평균: " + avg);
            }
            else if (selectNo == 5) {
                run = false;
            }
        }

    // 프로그램 종료
    System.out.println("프로그램 종료");
    }
}
