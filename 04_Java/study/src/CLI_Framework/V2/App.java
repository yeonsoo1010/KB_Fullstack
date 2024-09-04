//package CLI_Framework.V2;
//
//import java.util.Scanner;
//
//// App class: 메서드 모음
//public class App {
//    public static void main(String[] args) {
//        // 필드 선언
//        boolean run = true;
//        int studentNum = 0;
//        int[] scores = null;
//
//        // Scanner 불러오기
//        Scanner scanner = new Scanner(System.in);
//
//        // 메서드1: printMenu()
//        public void printMenu() {
//            System.out.println("--------------------------------");
//            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
//            System.out.println("--------------------------------");
//        }
//
//        // 메서드2: getSelect()
//        public int getSelect() {
//            System.out.println("선택> ");
//            // 입력값 받기
//            return Integer.parseInt(scanner.nextLine());
//        }
//
//        // 메서드3: getStudentNum() {
//        public void getStudentNum() {
//            // 받은 학생 수만큼, scores 배열 크기 정하기
//            System.out.println("학생수> ");
//            studentNum = Integer.parseInt(scanner.nextLine());
//            scores = new int[studentNum];
//        }
//
//        // 메서드4: getScores()
//        public void getScores() {
//            // scores 배열에 입력받은 점수들 집어넣기
//            for (int i = 0; i < scores.length; i++) {
//                // System.out.println("scores[" + i + "]> " + scores[i]);
//                System.out.println("scores[" + i + "]> ");
//                scores[i] = Integer.parseInt(scanner.nextLine());
//            }
//        }
//
//        // 메서드5: printScore()
//        public void printScore() {
//            // scores 배열 전체 출력하기
//            for (int i = 0; i < scores.length; i++) {
//                System.out.println("scores[" + i + "]> " + scores[i]);
//            }
//        }
//
//        // 메서드6: analyze()
//        public void analyze() {
//            int max = 0;
//            int sum = 0;
//            double avg = 0;
//
//            // 배열 돌면서 max 업데이트하기
//            for (int i = 0; i < scores.length; i++) {
//                max = (scores[i] > max) ? scores[i] : max;
//                sum += scores[i];
//            }
//            avg = (double) sum / studentNum; // 형변환
//            System.out.println("최고 점수: " + max);
//            System.out.println("평균 점수: " + avg);
//        }
//
//        // 메서드7: 종료
//        public void exit() {
//            run = false;
//        }
//
//
//        // 메서드8: executeCommand(int selectNo)
//        public void executeCommand(int selectNo) {
//            if (selectNo == 1) {
//                getStudentNum();
//            } else if (selectNo == 2) {
//                getScores();
//            } else if (selectNo == 3) {
//                printScore();
//            } else if (selectNo == 4) {
//                analyze();
//            } else if (selectNo == 5) {
//                exit();
//            }
//        }
//
//        // 메서드9: run() - 흐름 제어문
//        public void run () {
//            while (run) {
//                printMenu();
//                int selectNo = getSelect();
//                executeCommand(selectNo);
//            }
//
//            // 프로그램 종료
//            System.out.println("프로그램 종료");
//        }
//    }
//    public static void main (String[]args){
//        App app = new App();
//        app.run();
//    }
//}
