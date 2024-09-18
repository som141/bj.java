package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4 {
    static List<edge1>[]graph;
    static boolean [] b1;
    static int costRe;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s= bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        graph = new ArrayList[n+1];
        b1 = new boolean[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=m;i++){
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer1.nextToken());
            int b = Integer.parseInt(stringTokenizer1.nextToken());
            int c = Integer.parseInt(stringTokenizer1.nextToken());
            graph[a].add(new edge1(b,c));
            graph[b].add(new edge1(a,c));
        }
        PriorityQueue<edge1> pq = new PriorityQueue<>();
        pq.add(new edge1(1,0));
        while(!pq.isEmpty()){
            edge1 edge1= pq.poll();
            int v= edge1.v;
            int cost = edge1.cost;
            if(b1[v]){
                continue;
            }
            b1[v] = true;
            costRe += cost;
            for(edge1 edge: graph[v]){
                if(!b1[edge.v]){
                    pq.add(edge);
                }
            }

        }
        System.out.println(costRe);

    }
    static class edge1 implements Comparable<edge1> {
       int v;
       int cost;
       public edge1(int v, int cost) {
           this.v = v;
           this.cost = cost;
       }
       public int compareTo(edge1 o) {
           return cost - o.cost;
       }
    }
}
