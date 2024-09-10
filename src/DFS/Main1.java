package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1 {
    List<Edge>[] graph;
    private int n;

    public Main1(int n) {
        this.n = n;
        graph=new List[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s= String.valueOf(Integer.parseInt(bufferedReader.readLine()));
        StringTokenizer stringTokenizer = new StringTokenizer(s," ");
        int num1= Integer.parseInt(stringTokenizer.nextToken());
        int num2= Integer.parseInt(stringTokenizer.nextToken());
        int num3= Integer.parseInt(stringTokenizer.nextToken());
        Main1 main1 = new Main1(num1);
        for(int i=1;i<=num2;i++){
            String s1= String.valueOf(Integer.parseInt(bufferedReader.readLine()));
            StringTokenizer stringTokenizer1 = new StringTokenizer(s1," ");
            int n1= Integer.parseInt(stringTokenizer1.nextToken());
            int n2= Integer.parseInt(stringTokenizer1.nextToken());
            main1.graph[n1].add(new Edge(n2));
        }
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(main1.graph[num3] );

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
