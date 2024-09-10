package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    static ArrayList<Integer>[] graph; // 그래프 인접 리스트
    static boolean[] visited; // 방문 여부 체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점 번호

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u); // 무방향 그래프이므로 양방향 추가
        }

        // 각 리스트 정렬 (정점 번호가 작은 것부터 방문하기 위함)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 탐색
        visited = new boolean[N + 1]; // 방문 배열 초기화
        dfs(V);
        System.out.println(); // 줄바꿈

        // BFS 탐색
        visited = new boolean[N + 1]; // 방문 배열 초기화
        bfs(V);
    }

    // DFS 함수 (재귀로 구현)
    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " "); // 현재 노드 출력

        for (int nextV : graph[v]) {
            if (!visited[nextV]) {
                dfs(nextV); // 재귀 호출로 다음 노드 탐색
            }
        }
    }

    // BFS 함수 (큐로 구현)
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " "); // 현재 노드 출력

            for (int nextV : graph[v]) {
                if (!visited[nextV]) {
                    visited[nextV] = true;
                    queue.add(nextV); // 큐에 다음 노드 추가
                }
            }
        }
    }
}