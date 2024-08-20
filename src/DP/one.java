package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class one {

    public static int[]dp;
    public static int minN(int n){
        dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+1;
            if(i%2==0){
                dp[i]=Math.min(dp[i/2],dp[i-1])+1;
            }
            if(i%3==0){
                dp[i]=Math.min(dp[i/3],dp[i-1])+1;
            }

        }
        return dp[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        System.out.println(minN(number));
        br.close();
    }
}
