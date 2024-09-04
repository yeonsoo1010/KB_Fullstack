package baekjoon;

import java.util.Scanner;

public class 연결요소개수 {

    public static int[][] branch;
    public static boolean[] visit;
    public static int N;
    public static int M;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 노드 개수
        M = sc.nextInt(); // 간선 개수

        branch = new int[N+1][N+1];
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            branch[a][b] = branch[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            DFS(i);
            count++;
        }

        System.out.print(count);
    }

    public static void DFS(int start) {
        visit[start] = true;
        for (int i = 1; i <= N; i++) {
            if (branch[start][i] == 1 && visit[i] == false) {
                DFS(i);
            }
        }

    }
}
