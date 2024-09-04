package baekjoon;


import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSBFS {

    public static int[][] branch;
    public static boolean[] visit;
    public static Queue<Integer> queue;
    public static int N;
    public static int M;
    public static int V;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 노드 개수
        M = sc.nextInt(); // 간선 개수
        V = sc.nextInt(); // 시작 노드

        branch = new int[N+1][N+1]; // 노드가 1~N (N+1개)
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            branch[a][b] = branch[b][a] = 1;
        }

        DFS(V);
        System.out.println();

        Arrays.fill(visit, false);
        BFS(V);
    }

    public static void DFS(int start) {
        visit[start] = true; // 시작 노드, 계속 반복될 노드를 방문한 것으로 바꿔줌
        System.out.print(start + " ");
        for (int i = 1; i <= N; i++) {
            if (branch[start][i] == 1 && visit[i] == false) { //방문하지 않은, 지금 노드와 연결되어 있는 노드면
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        queue = new LinkedList<Integer>();
        // 시작 노드를 큐에 넣고 방문한 것으로 바꿔주기
        queue.add(start);
        visit[start] = true;
        System.out.print(start + " ");

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i < branch.length; i++) {
                if (branch[cur][i] == 1 && visit[i] == false) { //방문하지 않은, 지금 노드와 연결되어 있는 노드면
                    queue.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
