package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    PriorityQueue<Edge>[] graph;
    PriorityQueue<Edge>[] graph1;
    private int n;

    public Main1(int n) {
        this.n = n;
        graph=new PriorityQueue[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new PriorityQueue<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s= bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s," ");
        int num1= Integer.parseInt(stringTokenizer.nextToken());
        int num2= Integer.parseInt(stringTokenizer.nextToken());
        int num3= Integer.parseInt(stringTokenizer.nextToken());
        Main1 main1 = new Main1(num1);
        for(int i=1;i<=num2;i++){
            String s1= bufferedReader.readLine();
            StringTokenizer stringTokenizer1 = new StringTokenizer(s1," ");
            int n1= Integer.parseInt(stringTokenizer1.nextToken());
            int n2= Integer.parseInt(stringTokenizer1.nextToken());
            main1.graph[n1].add(new Edge(n2));
        }
        boolean visit1[]= new boolean[num1+1];
        boolean visit2[]= new boolean[num1+1];
        Arrays.fill(visit1,false);
        Arrays.fill(visit2,false);

        main1.dfs(num3,visit1);
        System.out.println();
        System.out.print(num3+" ");
        main1.bfs(num3,visit2);




    }
    public void dfs(int v,boolean[] visit){
        visit[v]=true;
        System.out.print(v+" ");
        PriorityQueue<Edge> edges=new PriorityQueue<>(graph[v]);
        while (!edges.isEmpty()){
            int v1= edges.poll().v;
            if (!visit[v1]){
                dfs(v1,visit);
            }
        }

    }
    public void bfs(int v,boolean[] visit){
        visit[v]=true;
        for(Edge edge: graph[v]) {
            int v1 = edge.v;
            if (!visit[v1]) {
                System.out.print(v1 + " ");
            }
        }
        while(!graph[v].isEmpty()){
            int v2= graph[v].poll().v;
            if(!visit[v2]){
                bfs(v2,visit);
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int v;

        public Edge(int v) {
            this.v = v;
        }


        @Override
        public int compareTo(Edge o) {
            return this.v-o.v;
        }
    }
}
