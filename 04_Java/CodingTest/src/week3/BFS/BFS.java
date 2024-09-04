package week3.BFS;

import java.util.*;

public class BFS {
    // 전역변수 만들기
    Map<Integer, List<Integer>> graph = new HashMap<>();

    // public static void makeGraph() {
    public void makeGraph() {
        graph.put(0, Arrays.asList(1, 3, 6));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(0, 1, 2, 7));
        graph.put(4, Arrays.asList(5));
        graph.put(5, Arrays.asList(4, 6, 7));
        graph.put(6, Arrays.asList(0, 5));
        graph.put(7, Arrays.asList(3, 5));
    }

    public Set<Integer> bfs(Integer start) {
        // visited: 예약 완료
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        // queue: 예약된 숫자들 넣어놓는 큐
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start); // start를 예약에 넣어놓기

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            Integer current = queue.remove();
            for (Integer v : graph.get(current)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        BFS bfsInstance = new BFS();
        bfsInstance.makeGraph(); // graph 초기화
        Set<Integer> result = bfsInstance.bfs(0); // bfs 호출

        // 결과값 프린트
        System.out.println("BFS traversal starting from node 0: " + result);
    }
}


