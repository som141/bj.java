package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class unionFind{
    private int[] parent;
    private int[] rank;


    public unionFind(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x,int y){
        int rootX= find(x);
        int rootY= find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int u;
    int v;
    int cost;

    public Edge(int u,int v, int cost) {
        this.u= u;
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost-o.cost;
    }
}

public class kruskalEx{

    public int kruskal(int n, List<Edge> edges) {
        Collections.sort(edges);
        unionFind uf = new unionFind(n);

        int totalWeight = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (uf.find(edge.u) != uf.find(edge.v)) {
                uf.union(edge.u, edge.v);
                totalWeight += edge.cost;
                edgeCount++;

                if (edgeCount == n - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) throws IOException {
       kruskalEx kr= new kruskalEx();
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num1= Integer.parseInt(bufferedReader.readLine());
        List<Edge> edgeList = new ArrayList<>();
        int num2= Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<num2;i++){
            String string=bufferedReader.readLine();
            StringTokenizer stringTokenizer= new StringTokenizer(string," ");
            edgeList.add(new Edge(Integer.parseInt(stringTokenizer.nextToken()),Integer.parseInt(stringTokenizer.nextToken()),Integer.parseInt(stringTokenizer.nextToken())));
        }
        System.out.println(kr.kruskal(num1,edgeList));
    }
}
