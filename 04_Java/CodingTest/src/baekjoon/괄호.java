package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine()); // 입력받은 횟수

        for (int i=0; i<cnt; i++) {
            String line = br.readLine();
            String answer = "YES"; // 기본 값을 "YES"로 설정

            Deque<Character> stack = new ArrayDeque<>();
            for (char tmp : line.toCharArray()) {
                if (tmp == '(') { // 열린 괄호는 add
                    stack.add(tmp);
                } else if (tmp == ')') { // 닫힌 괄호는 pop
                    if (stack.isEmpty()) {
                        answer = "NO"; // 이미 비어있으면 안됨. 조심 !! 없으면 pop할 때 문제가 됨
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) { answer = "NO"; }

            System.out.println(answer);
        }
    }
}
