package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10 {
    private static int arr[][];
    private static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        arr = new int[2][num + 1];
        dp = new int[num+1];

        for (int i = 1; i <= num; i++) {
            String line = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            arr[0][i] = Integer.parseInt(stringTokenizer.nextToken());
            arr[1][i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int i=1;i<=num;i++) {
            dp[0] = 0;
            dp[i] = 0;

            int max = 0;
            for (int j = 1; j <= i; j++) {

                if (j + arr[0][j] - 1 == i) {
                    max = Math.max(max, dp[j - 1] + arr[1][j]);
                }

            }

            if(max>dp[i-1]){
                dp[i]=max;
            }
            else{
                dp[i]=dp[i-1];
            }

        }
        System.out.println(dp[num]);
}
}
