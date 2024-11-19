package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main27 {
    static int N;
    static int MaxW;
    static int[][]dp;
    static int []w;
    static int []c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        StringTokenizer st = new StringTokenizer(s1);
        N = Integer.parseInt(st.nextToken());
        MaxW = Integer.parseInt(st.nextToken());
        dp = new int[N+1][MaxW+1];
        w = new int[N+1];
        c = new int[N+1];
        for(int i=1;i<N+1;i++){
            String s2=br.readLine();
            StringTokenizer st2 = new StringTokenizer(s2);
            w[i] = Integer.parseInt(st2.nextToken());
            c[i] = Integer.parseInt(st2.nextToken());
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<=MaxW;j++){
                if(w[i]<=j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+c[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][MaxW]);
    }
}
