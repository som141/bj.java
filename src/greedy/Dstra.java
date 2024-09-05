package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph{
    private int vertices;
     List<Edge> Graph[];

    public Graph(int n) {
        this.vertices = n;
        Graph= new ArrayList[vertices+1];
        for(int i=1;i<=vertices;i++){
            Graph[i]= new ArrayList<>();
        }//생성자 injection ;;

    }




    static class Edge implements Comparable<Edge>{

        int v;
        int cost;

        public Edge( int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
}
public class Dstra {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        String s= bufferedReader.readLine();
        StringTokenizer stringTokenizer= new StringTokenizer(s," ");
        int num1= Integer.parseInt(stringTokenizer.nextToken());
        int num2= Integer.parseInt(stringTokenizer.nextToken());
        int num3= Integer.parseInt(stringTokenizer.nextToken());
        Graph graph = new Graph(num1);
        for(int i=1;i<=num2;i++){
            String s1= bufferedReader.readLine();
            StringTokenizer stringTokenizer1= new StringTokenizer(s1," ");
            int n1= Integer.parseInt(stringTokenizer1.nextToken());
            int n2= Integer.parseInt(stringTokenizer1.nextToken());
            int n3= Integer.parseInt(stringTokenizer1.nextToken());
            graph.Graph[n1].add(new Graph.Edge(n2,n3));
        }
        int d[]=new int[num1+1];
        boolean b[]=new boolean[num1+1];
        PriorityQueue<Graph.Edge> pq= new PriorityQueue<>();
        Arrays.fill(d,Integer.MAX_VALUE);
        d[0]=0;
        d[num3]=0;
        pq.add(new Graph.Edge(num3,0));
        while(!pq.isEmpty()){
            int currentV=pq.poll().v;
            if(b[currentV]){
                continue;
            }
            b[currentV]=true;
            for(Graph.Edge edge : graph.Graph[currentV]){
                int v=edge.v;
                int newDist= edge.cost+d[currentV];
                if(!b[v]&&newDist<d[v]){
                    d[v]=newDist;
                    pq.add(new Graph.Edge(v,newDist));
                }
            }
        }
        Arrays.sort(d);
        System.out.println(d[num1]);
    }
}
