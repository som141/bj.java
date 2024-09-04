package greedy;

import java.util.ArrayList;
import java.util.List;

class Graph{
    private int vertices;
    private List<Edge> Graph[];

    public Graph(int n) {
        this.vertices = n;
        Graph= new ArrayList[vertices+1];
        for(int i=1;i<=vertices;){
            Graph[i]= new ArrayList<>();
        }//생성자 injection ;;

    }




    static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
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
}
