package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11 {//main10 알고리즘 간소화 o(n) 으로 줄이기 가능!
    private static int arr[][];
    private static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        arr = new int[2][num + 2];
        dp = new int[num+2];

        for (int i = 1; i <= num; i++) {
            String line = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            arr[0][i] = Integer.parseInt(stringTokenizer.nextToken());
            arr[1][i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int max= 0;
        dp[0] = 0;
        for(int i=1;i<=num+1;i++) {
            if(dp[i]>max){
                max=dp[i];
            }
            if(i+arr[0][i]<=num+1) {
                dp[i + arr[0][i] ] = Math.max(arr[1][i]+max,dp[i+arr[0][i]]);
            }


        }
        System.out.println(max);
}
}
