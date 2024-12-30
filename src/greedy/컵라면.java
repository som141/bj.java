package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 컵라면 {
    static int num;
    static int result;
    static Queue<node> pq;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        for(int i=1;i<=num;i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            pq.add(new node(a,b));
        }
        solve();
        System.out.println(result);
    }

    private static void solve() {

        for(int i=1;i<=num;i++){
            if(!pq.isEmpty()){
                node node=pq.poll();
                result=result+node.cost;

            while(!pq.isEmpty()&&pq.peek().dadeLine<=i){
                pq.poll();
            }
            if(pq.isEmpty()){
                break;
            }
            }
        }


    }

    static class node implements Comparable<node>{
        int dadeLine;
        int cost;

        public node(int v, int cost) {
            this.dadeLine = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {

            return o.cost - this.cost;
        }
    }
}
