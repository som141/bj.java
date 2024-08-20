package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    static int[]dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(bufferedReader.readLine());
        dp=new int[num+1];
        System.out.println(bottom3(num));

    }
    static int bottom3(int n){
        dp[1]=1;
        dp[2]=3;
        for(int i=3;i<=n;i++){
            dp[i]=2*dp[i-2]+dp[i-1];
            dp[i]%=10007;
        }
        return dp[n];

    }
}
