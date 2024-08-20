package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
    static int dp[];
    static int p[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        dp = new int[num + 1];

        String line= bufferedReader.readLine();
        StringTokenizer stringTokenizer= new StringTokenizer(line," ");
        int s1 = stringTokenizer.countTokens();
        p = new int[s1 +1];
        for(int i=1;i<=s1;i++){
            p[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        System.out.println(add4(num, p));
    }

    static int add4(int n, int[] p) {
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <=i; j++) {
                int temp = dp[i - j] + p[j];
                if (temp > max) {
                    max = temp;
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }
}