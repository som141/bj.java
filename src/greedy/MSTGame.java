package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MSTGame {
    static int node;
    static int edge;
    static int k;
    static Queue<graph> q=new PriorityQueue<>();
    static List<graph>[] graphs;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graphs = new List[node+1];
        for(int i=0;i<=node;i++){
            graphs[i] = new ArrayList<graph>();
        }
        for(int i=1;i<=edge;i++){
            String s1 = br.readLine();
            StringTokenizer st1 = new StringTokenizer(s1);
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            graphs[u].add(new graph(v,i));
            graphs[v].add(new graph(u,i));
        }
        for(int i=1;i<=k;i++){
            int result= MstGame();
            System.out.println(result);
        }

    }

    private static int MstGame() {
        int result=0;
        PriorityQueue<graph> pq = new PriorityQueue<graph>();
        boolean[] visited=new boolean[node+1];
        pq.add(new graph(1,0));
        while(!pq.isEmpty()){

            graph current = pq.poll();
            if(visited[current.v]){
                continue;
            }
            visited[current.v]=true;
            q.add(current);
            result+=current.cost;
            for(graph g : graphs[current.v]){
                if(!visited[g.v]){

                        pq.add(new graph(g.v,g.cost));

                }
            }
        }
        return result;
    }

    static class graph implements Comparable<graph> {
        int v;
        int cost;

        public graph(int v,int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(graph o) {
            return this.cost - o.cost;
        }
    }
}
