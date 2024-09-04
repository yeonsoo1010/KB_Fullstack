package ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList( //왜 Arrays.asList?
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("감자바", 30)
        );

        double avg = list.stream()
                .mapToInt(s -> s.getScore())
                .average() //IntStream의 내장 메소드
                .getAsDouble();

        System.out.println("평균 점수: " + avg);

    }
}
