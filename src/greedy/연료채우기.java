package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연료채우기 {
    static int caseN;
    static int last;
    static int firstCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        caseN = Integer.parseInt(br.readLine());
        node []list=new node[caseN];
        for(int i = 0; i < caseN; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int d=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[i]=new node(d,c);
        }
        String s1 = br.readLine();
        StringTokenizer st = new StringTokenizer(s1);
        last=Integer.parseInt(st.nextToken());
        firstCost=Integer.parseInt(st.nextToken());
        Arrays.sort(list,(a,b)->a.distance-b.distance);
        int remainCost=firstCost;
        for(int i = 0; i < caseN; i++) {
            while(remainCost>=list[i].distance) {
                Queue<node> pq=new PriorityQueue<>();
            }
        }
    }
    static class node implements Comparable<node>{
        int distance;
        int cost;

        public node(int distance, int cost) {
            this.distance = distance;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost-o.cost;
        }
    }
}
