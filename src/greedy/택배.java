package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class 택배 {
    static int num;
    static int maxCost;
    static int caseN;
    static List<node> node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1= br.readLine();
        StringTokenizer st = new StringTokenizer(input1);
        num = Integer.parseInt(st.nextToken());
        maxCost = Integer.parseInt(st.nextToken());
        caseN= Integer.parseInt(br.readLine());
        for(int i=1;i<=caseN;i++){

        }
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
