package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static boolean []visit;
    static int []d;
    static List<edge> graph[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int start = Integer.parseInt(br.readLine());
        d = new int[N+1];
        visit = new boolean[N+1];
        graph=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i]=new ArrayList<edge>();
        }
        for(int i=1;i<=M;i++){
            String s1= br.readLine();
            StringTokenizer stringTokenizer1 = new StringTokenizer(s1);
            int u = Integer.parseInt(stringTokenizer1.nextToken());
            int v = Integer.parseInt(stringTokenizer1.nextToken());
            int cost = Integer.parseInt(stringTokenizer1.nextToken());
            graph[u].add(new edge(v,cost));
        }
        Arrays.fill(d,Integer.MAX_VALUE);
        PriorityQueue<edge> pq = new PriorityQueue<edge>();
        pq.add(new edge(start,0));
        d[start]=0;
        while(!pq.isEmpty()){
            int currentV = pq.poll().v;
            if(visit[currentV]){
                continue;
            }
            visit[currentV]=true;
            for(edge edge: graph[currentV]){
                int v = edge.v;
                int dist=edge.cost+d[currentV];
                if(!visit[v]&&dist<d[v]){
                    d[v]=dist;
                    pq.add(new edge(v,dist));
                }


            }



        }
        for(int i=1;i<=N;i++){
            if(d[i]==Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(d[i]);
            }
        }

    }
    static class edge implements Comparable<edge>{
        int v;
        int cost;
        public edge(int v, int cost) {
            this.v=v;
            this.cost=cost;
        }

        @Override
        public int compareTo(edge o) {
            return this.cost-o.cost;
        }
    }
}
