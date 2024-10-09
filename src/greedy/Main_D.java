package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_D {
    static int num, caseN;
    static List<graph>[] g;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        caseN = Integer.parseInt(st.nextToken());

        g = new LinkedList[num + 1];
        for (int i = 1; i <= num; i++) {
            g[i] = new LinkedList<>();
        }

        for (int i = 1; i <= caseN; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new graph(b, c));
            g[b].add(new graph(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int route1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, num);
        int route2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, num);


        if (route1 >= Integer.MAX_VALUE && route2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            int result = Math.min(route1, route2);
            System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        }
    }

    static int dijkstra(int start, int end) {
        d = new int[num + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<graph> pq = new PriorityQueue<>();
        pq.add(new graph(start, 0));

        while (!pq.isEmpty()) {
            graph currentV = pq.poll();

            if (currentV.v == end) {
                return d[end];
            }

            for (graph nextV : g[currentV.v]) {
                if (d[currentV.v] + nextV.cost < d[nextV.v]) {
                    d[nextV.v] = d[currentV.v] + nextV.cost;
                    pq.add(new graph(nextV.v, d[nextV.v]));
                }
            }
        }

        return d[end];
    }

    static class graph implements Comparable<graph> {
        int v, cost;

        public graph(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(graph o) {
            return this.cost - o.cost;
        }
    }
}
