package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph1{
    private int n;
     List<edge1>[] graph;

    public Graph1(int n) {
        this.n = n;
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
    }
    void addEdge(int src, int dest, int weight) {
        graph[src].add(new edge1(dest, weight));
    }


}
class edge1 implements Comparable<edge1>{
    int v;

    public edge1(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    int cost;


    @Override
    public int compareTo(edge1 o) {
        return this.cost-o.cost;
    }
}
public class Main3  {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s= bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s," ");
        int num1 = Integer.parseInt(stringTokenizer.nextToken());
        int num2 = Integer.parseInt(stringTokenizer.nextToken());
        int num3 = Integer.parseInt(stringTokenizer.nextToken());
        Graph1 graph1= new Graph1(num1);
        for(int i=1;i<=num2;i++){
            String s1= bufferedReader.readLine();
            StringTokenizer stringTokenizer1 = new StringTokenizer(s1," ");
            int n1 = Integer.parseInt(stringTokenizer1.nextToken());
            int n2 = Integer.parseInt(stringTokenizer1.nextToken());
            int n3 = Integer.parseInt(stringTokenizer1.nextToken());
            graph1.addEdge(n1,n2,n3);
        }
        PriorityQueue<edge1> pq= new PriorityQueue<>();

        int d[]= new int[num1+1];
        boolean b[]= new boolean[num1+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        Arrays.fill(b,false);
        d[0]=0;
        d[num3]=0;
        pq.add(new edge1(num3,0));
        while(!pq.isEmpty()){
            int currentV=pq.poll().v;
            if(b[currentV]){
                continue;
            }
            b[currentV]=true;
            for (edge1 edge1:graph1.graph[currentV]){
                int v= edge1.v;
                int newDist=d[currentV]+edge1.cost;
                if(!b[v]&&newDist<d[v]){
                    d[v]= newDist;
                    pq.add(new edge1(v,newDist));
                }
            }
        }
        Arrays.sort(d);
        System.out.println(d[num1]);

    }
}
