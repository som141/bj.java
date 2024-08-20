package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6 {
    static long[]dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(bufferedReader.readLine());
        dp=new long[num+1];
        System.out.println(bottom3(num));

    }
    static long bottom3(int n){
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];

    }
}
