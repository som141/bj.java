package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17v1 {
    static long dp[][][];
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        dp= new long[num+1][10][1<<10];
        for(int i=1;i<=9;i++){
            dp[1][i][1<<i]=1;
        }
        for(int i=2;i<=num;i++){
            for(int j=0;j<=9;j++){
                for(int b=0;b<(1<<10);b++){
                    int bitmask= b|(1<<j);
                    if(j==0){
                        dp[i][j][bitmask]+=dp[i-1][j+1][b]%MOD;
                    }
                    else if(j==9){
                        dp[i][j][bitmask]+=dp[i-1][j-1][b]%MOD;
                    }
                    else{
                        dp[i][j][bitmask]+=(dp[i-1][j+1][b]%MOD+dp[i-1][j-1][b]%MOD);
                    }
                    dp[i][j][bitmask] %= MOD;
                }

            }
        }
        long ans=0;
        for(int i=0;i<10;i++){
            ans+=dp[num][i][1023]%MOD;
            ans= ans%MOD;
        }
        System.out.println(ans);
    }
}
