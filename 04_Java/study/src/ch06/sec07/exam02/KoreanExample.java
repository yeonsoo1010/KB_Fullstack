package ch06.sec07.exam02;

public class KoreanExample {
 public static void main(String[] args) {
     // Korean 객체 생성
     Korean Korean1 = new Korean("박자바", "011225-1234567");

     // 또다른 Korean 객체 생성
     Korean Korean2 = new Korean("김자바", "930525-0654321");

     // 테스트 출력
     System.out.println(Korean1);
     System.out.println("Korean1.nation: " + Korean1.nation);
     System.out.println("Korean1.name: " + Korean1.name);
     System.out.println("Korean1.ssn: " + Korean1.ssn);
     System.out.println();

     System.out.println(Korean2);
     System.out.println("Korean2.nation: " + Korean2.nation);
     System.out.println("Korean2.name: " + Korean2.name);
     System.out.println("Korean2.ssn: " + Korean2.ssn);
 }
}

