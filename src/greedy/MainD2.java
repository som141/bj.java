package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainD2 {
    static int num;
    static int caseN;
    static boolean[] visit;
    static boolean[] visibility;
    static List<graph>[] g;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        StringTokenizer st = new StringTokenizer(s1);
        num = Integer.parseInt(st.nextToken());
        caseN = Integer.parseInt(st.nextToken());
        visibility = new boolean[num];
        visit = new boolean[num];
        g = new ArrayList[num];
        d = new int[num];

        String s2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s2);

        for (int i = 0; i < num; i++) {
            g[i] = new ArrayList<>();
            int v = Integer.parseInt(st2.nextToken());
            visibility[i] = v == 1;
        }


        for (int i = 0; i < caseN; i++) {
            String s3 = br.readLine();
            StringTokenizer st3 = new StringTokenizer(s3);
            int u = Integer.parseInt(st3.nextToken());
            int v = Integer.parseInt(st3.nextToken());
            int cost = Integer.parseInt(st3.nextToken());


            if ((!visibility[u] || u == num - 1) && (!visibility[v] || v == num - 1)) {
                g[u].add(new graph(v, cost));
                g[v].add(new graph(u, cost));
            }
        }


        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        PriorityQueue<graph> pq = new PriorityQueue<>();
        pq.add(new graph(0, 0));


        while (!pq.isEmpty()) {
            graph currentV = pq.poll();
            if (visit[currentV.v]) {
                continue;
            }
            visit[currentV.v] = true;


            for (graph Next : g[currentV.v]) {
                if (!visit[Next.v] && Next.cost + d[currentV.v] < d[Next.v]) {
                    d[Next.v] = Next.cost + d[currentV.v];
                    pq.add(new graph(Next.v, d[Next.v]));
                }
            }
        }


        System.out.println(d[num - 1] == Integer.MAX_VALUE ? -1 : d[num - 1]);
    }

    static class graph implements Comparable<graph> {
        int v;
        int cost;

        public graph(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(graph o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
