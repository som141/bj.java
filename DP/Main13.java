package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13 {
    static int arr[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        arr= new int[num+1];
        dp= new int[num+1];
        for(int i=1; i<=num;i++){
            arr[i]=Integer.parseInt(bufferedReader.readLine());
        }
        dp[1]=arr[1];
        dp[0]=0;
        dp[2]=arr[1]+arr[2];
        int sum=0;
        for(int i=3;i<=num;i++){

            dp[i] = Math.max(arr[i - 1]+dp[i-3], dp[i - 2]) + arr[i];





        }
        System.out.println(dp[num]);
    }
}
