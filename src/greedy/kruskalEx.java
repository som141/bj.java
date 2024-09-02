package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class unionFind{
    private int[] parent;
    private int[] rank;

    public unionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
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
            // 랭크를 비교해 더 작은 트리를 큰 트리에 붙임
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

    public static int kruskal(int n, List<Edge> edges) {
        // n: 정점의 수, edges: 간선 리스트
        Collections.sort(edges); // 간선을 가중치 기준으로 정렬
        unionFind uf = new unionFind(n);

        int totalWeight = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (uf.find(edge.u) != uf.find(edge.v)) {
                uf.union(edge.u, edge.v);
                totalWeight += edge.cost;
                edgeCount++;

                // n-1개의 간선을 선택하면 MST 완성
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        int n = 4; // 정점의 수
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int totalWeight = kruskal(n, edges);
        System.out.println("Minimum Spanning Tree cost: " + totalWeight);
    }
}
