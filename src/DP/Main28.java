package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main28 {
    static int num;
    static int num2;
    static int [][]dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(br.readLine());
        num2= Integer.parseInt(br.readLine());
        dp= new int[2][num2+1];
        graph1[] graph = new graph1[2];
            graph[0]=new graph1(1,1);
            graph[1]=new graph1(num,num );
        Queue<graph1> q = new LinkedList<>();
        for(int i=0;i<num2;i++){
            String s1= br.readLine();
            StringTokenizer st= new StringTokenizer(s1," ");
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            q.offer(new graph1(x,y));
        }
        for(int i=1;i<=num2;i++){
            graph1 g= q.poll();
            int x= g.x;
            int y= g.y;
            for(int j=0;j<2;j++){
                int prev1 = dp[0][i - 1] + (Math.abs(graph[j].x - x) + Math.abs(graph[j].y - y));
                int prev2 = dp[1][i - 1] + (Math.abs(graph[j].x - x) + Math.abs(graph[j].y - y));
                dp[j][i]=Math.min(prev1,prev2);
            }

        }
        int result = Math.min(dp[0][num2], dp[1][num2]);
        System.out.println(result);
    }

    static class graph1{
        int x;
        int y;

        public graph1(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
