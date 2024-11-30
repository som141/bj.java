package goldRandomDepense;

import java.io.*;
import java.util.*;

public class MSTGame {
    static int node;
    static int edge;
    static int k;
    static List<graph>[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graphs = new List[node + 1];
        for (int i = 0; i <= node; i++) {
            graphs[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 1; i <= edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graphs[u].add(new graph(u, v, i));
            graphs[v].add(new graph(v, u, i));
        }

        // 각 턴의 결과 저장
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int result = MstGame();
            results.add(result);

            // MST를 만들 수 없으면 이후 모두 0
            if (result == 0) {
                while (results.size() < k) {
                    results.add(0);
                }
                break;
            }

            // 가장 작은 가중치의 간선 제거
            graph smallestEdge = findSmallestEdge();
            if (smallestEdge != null) {
                graphs[smallestEdge.u].remove(smallestEdge);
                graphs[smallestEdge.v].remove(new graph(smallestEdge.v, smallestEdge.u, smallestEdge.cost));
            }
        }

        // 결과 출력
        System.out.println(String.join(" ", results.stream().map(String::valueOf).toArray(String[]::new)));
    }

    // MST 계산
    private static int MstGame() {
        int result = 0;
        PriorityQueue<graph> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[node + 1];
        pq.add(new graph(0, 1, 0)); // 시작점

        int visitedCount = 0; // 방문한 정점 수
        while (!pq.isEmpty()) {
            graph current = pq.poll();
            if (visited[current.v]) {
                continue;
            }

            visited[current.v] = true;
            result += current.cost;
            visitedCount++;

            for (graph g : graphs[current.v]) {
                if (!visited[g.v]) {
                    pq.add(g);
                }
            }
        }

        // MST를 만들 수 없는 경우
        if (visitedCount != node) {
            return 0;
        }

        return result;
    }

    // 가장 작은 간선 찾기
    private static graph findSmallestEdge() {
        graph smallest = null;
        for (List<graph> adjList : graphs) {
            for (graph g : adjList) {
                if (smallest == null || g.cost < smallest.cost) {
                    smallest = g;
                }
            }
        }
        return smallest;
    }

    // 간선 클래스
    static class graph implements Comparable<graph> {
        int u;
        int v;
        int cost;

        public graph(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(graph o) {
            return Integer.compare(this.cost, o.cost);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            graph other = (graph) obj;
            return u == other.u && v == other.v && cost == other.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v, cost);
        }
    }
}
