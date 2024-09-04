package ch17.sec03;

public class Student {
    // 필드
    private String name;
    private int score;

    // 생성자
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // get 메서드
    public String getName() { return name; }
    public int getScore() { return score; }
}
