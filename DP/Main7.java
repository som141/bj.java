package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main7 {
    private static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        dp= new int[10][num+1];
        for (int i=0;i<10;i++){
            dp[i][1]=1;
        }
        for (int i=2;i<=num;i++){
            for(int j=0;j<10;j++){
                int sum=0;
                for(int k=0;k<=j;k++){
                    sum+=dp[k][i-1];
                }
                dp[j][i]=sum%10007;
            }
        }
        int sum2=0;
        for(int i=0;i<10;i++){
            sum2+=dp[i][num];
            sum2%=10007;
        }
        System.out.println(sum2);

    }

}
