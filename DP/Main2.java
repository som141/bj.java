package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int []dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        dp= new int[length+1];
        System.out.println(recuone(length));

    }
    static int recuone(int n){
        if(n==1||n==0){
            return 1;
        }
        if(dp[n]>0){
            return dp[n];
        }

        dp[n]= recuone(n-1)+recuone(n-2);
        dp[n]%=10007;
        return dp[n];
    }
    static int onetwo(int n){
        int []dp= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=2;i<=n;i++){
            dp[i]= dp[i-1]+dp[i-2];
            dp[i]%=10007;
        }
        return dp[n];
    }
}
