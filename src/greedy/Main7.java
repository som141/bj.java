package greedy;

import java.io.*;
import java.util.*;

public class Main7 {
    static int num, num2;
    static List<Graph>[] g;
    static long[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        g = new List[num + 1];
        for (int i = 1; i <= num; i++) {
            g[i] = new ArrayList<>();
        }

        // 그래프 입력
        for (int i = 0; i < num2; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            g[u].add(new Graph(v, i));
            g[v].add(new Graph(u, i));
        }

        // 최소 시간 배열 초기화
        result = new long[num + 1];
        Arrays.fill(result, Long.MAX_VALUE);
        result[1] = 0;

        // 다익스트라 알고리즘 (우선순위 큐 사용)
        PriorityQueue<Graph> queue = new PriorityQueue<>();
        queue.add(new Graph(1, 0)); // 시작점 추가

        while (!queue.isEmpty()) {
            Graph current = queue.poll();
            int currentRegion = current.v;
            long currentTime = current.c;

            // 현재 시간이 최소 시간보다 크면 무시
            if (currentTime > result[currentRegion]) continue;

            // 인접 노드 탐색
            for (Graph next : g[currentRegion]) {
                long waitTime = (num2 - (currentTime % num2) + next.c) % num2;
                long newDist = currentTime + waitTime + 1;

                if (newDist < result[next.v]) {
                    result[next.v] = newDist;
                    queue.add(new Graph(next.v, newDist));
                }
            }
        }

        // 결과 출력
        System.out.println(result[num] == Long.MAX_VALUE ? -1 : result[num]);
    }

    static class Graph implements Comparable<Graph> {
        int v;
        long c;

        public Graph(int v, long c) {
            this.v = v; // 정점 번호
            this.c = c; // 누적 시간
        }

        @Override
        public int compareTo(Graph o) {
            return Long.compare(this.c, o.c);
        }
    }
}
