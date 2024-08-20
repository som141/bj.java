package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8 {
    private static int dp[][];
    private static int w[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<num;i++){
            int num1= Integer.parseInt(bufferedReader.readLine());
            dp=new int[2][num1+1];
            for(int j=1;j<=num1;j++){
                dp[0][j]=Integer.parseInt(bufferedReader.readLine());
            }
            for(int j=1;j<=num1;j++){
                dp[1][j]=Integer.parseInt(bufferedReader.readLine());
            }
            w=new int[2][num1+1];
            w[0][1] = dp[0][1];
            w[1][1] = dp[1][1];

            for(int k = 2; k<=num1; k++){
                w[0][k] = Math.max(w[1][k-1], w[1][k-2]) + dp[0][k];
                w[1][k] = Math.max(w[0][k-1], w[0][k-2]) + dp[1][k];
            }
            int max = Math.max(w[0][num1], w[1][num1]);
            System.out.println(max);
        }

    }

}
