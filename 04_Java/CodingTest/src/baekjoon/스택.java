package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int j = 1;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i<max; i++) {
            int in = Integer.parseInt(br.readLine());

            for ( ; j<=in; j++) {
                stack.push(j); // 1~in까지 싹 다 스택에 넣어주기
                sb.append("+").append("\n"); // +를 그 개수만큼 sb에 넣어주기
            }

            if (stack.peek() == in) {
                stack.pop(); // 맨 윗 stack이랑 같으면 그 값 pop
                sb.append("-").append("\n"); // -를 그 개수만큼 sb에 넣어주기
            } else {
                answer = "NO";
            }
        }

        if (answer != "NO") {
            answer = sb.toString();
        }

        System.out.println(answer);
    }
}
