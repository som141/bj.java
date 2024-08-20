package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main12 {
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        dp= new int[num+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=num;i++){
            dp[i]=(dp[i-1]+2*dp[i-2])%10007;
        }
        System.out.println(dp[num]);
    }

}
