package greedy;
class edge implements Comparable<edge>{
//    간선 표현
    int w;
    int cost;

    public edge(int w, int cost) {
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(edge o) {
        return this.cost-o.cost;
    }
}
public class ex1 {
}
