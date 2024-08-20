package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<num1;i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            dp = new int[Math.max(num + 1,4)];
            System.out.println(add4(num));
        }
    }
    static int add4(int n){
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
