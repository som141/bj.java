package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 택배 {
    static int num;
    static int maxCost;
    static int caseN;
    static node []node ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1= br.readLine();
        StringTokenizer st = new StringTokenizer(input1);
        num = Integer.parseInt(st.nextToken());
        maxCost = Integer.parseInt(st.nextToken());
        caseN= Integer.parseInt(br.readLine());
        node = new node[caseN];
        for(int i=0;i<caseN;i++){
            String input2= br.readLine();
            StringTokenizer st2 = new StringTokenizer(input2);
            int a= Integer.parseInt(st2.nextToken());
            int b= Integer.parseInt(st2.nextToken());
            int c= Integer.parseInt(st2.nextToken());
            node[i]=new node(a,b,c);
        }
        solve();
    }

    private static void solve() {
        Arrays.sort(node, (a,b)-> {
            if(a.to==b.to){
                return a.from-b.from;
            }
            return a.to-b.to;
        });
        int []currentW=new int[num+1];
        int result=0;
        for(node node1:node){
            int max=0;
            for(int i=node1.from;i<node1.to;i++){
                 max=Math.max(max,currentW[i]);
            }
            int availableSpace=Math.min(maxCost-max,node1.cost);

            for(int i=node1.from;i<node1.to;i++){
                currentW[i]+=availableSpace;
            }
            result+=availableSpace;

        }
        System.out.println(result);




    }

    static class node{
        int from;
        int to;
        int cost;

        public node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
