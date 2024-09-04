package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 요세푸스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 첫 번째 토큰이 n개
        int k = Integer.parseInt(st.nextToken()); // 두 번째 토큰이 k번째

        // 큐 만들기
        List<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while (!que.isEmpty()) { // list가 비기 전까지 계속 반복
            // 리스트 사이즈를 넘어가면 계속 반복 -> 알파벳 순환과 같은 구조 !!
            index = (index + (k - 1)) % que.size();
            sb.append(que.remove(index));
            if (!que.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
