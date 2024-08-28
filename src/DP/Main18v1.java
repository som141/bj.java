package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main18v1 {
    static int dp[][];
    static int w[][];
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(bufferedReader.readLine());
        dp= new int[num+1][(1<<num)];
        w= new int[num+1][num+1];
        for( int i= 1;i<=num;i++){
            String s= bufferedReader.readLine();
            StringTokenizer stringTokenizer= new StringTokenizer(s," ");
            for( int j=1;j<=num;j++){
                w[i][j]= Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for(int i=1; i<=num;i++){
            Arrays.fill(dp[i],-1);
        }


    }
    public static int tsp(int start, int visit) {
        if (visit == (1 << num)) {
            if (dp[start][1] == 0)
                return Integer.MAX_VALUE;

            return dp[start][0];
        }
    }
}