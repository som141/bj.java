package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mainprem {
    static int num;
    static int c;
    static List<graph>[]g;
    static boolean[]visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input=bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input);
        num = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        g=new ArrayList[num+1];
        visited=new boolean[num+1];
        for(int i=1;i<=num;i++){
            g[i]=new ArrayList<>();
        }
        for(int i=1;i<=c;i++){
            String s = bufferedReader.readLine();
            StringTokenizer stringTokenizer1 = new StringTokenizer(s);
            int a = Integer.parseInt(stringTokenizer1.nextToken());
            int b = Integer.parseInt(stringTokenizer1.nextToken());
            int c = Integer.parseInt(stringTokenizer1.nextToken());
            g[a].add(new graph(b,c));
            g[b].add(new graph(a,c));
        }
        PriorityQueue<graph> q=new PriorityQueue<>();
        q.add(new graph(1,0));
        int result=0;
        while(!q.isEmpty()){
            graph currentV=q.poll();
            if(visited[currentV.v])continue;
            visited[currentV.v]=true;
            result+=currentV.cost;
            for(graph nextV:g[currentV.v]){
                if(!visited[nextV.v]){
                    q.add(nextV);
                }
            }
        }
        System.out.println(result);

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
            return this.cost-o.cost;
        }
    }
}
