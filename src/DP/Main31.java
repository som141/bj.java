package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main31 {
    static int num;
    static int[][] dp;
    static int[][] arr;
    static final int MAX_VALUE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        dp = new int[num][1 << num];
        arr = new int[num][num];

        for (int i = 0; i < num; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < num; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = solve(0, 1);
        System.out.println(result);
    }

    private static int solve(int current, int visited) {
        if (visited == (1 << num) - 1) {
            return arr[current][0] == 0 ? MAX_VALUE : arr[current][0];
        }

        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        dp[current][visited] = MAX_VALUE;

        for (int next = 0; next < num; next++) {
            if ((visited & (1 << next)) == 0 && arr[current][next] != 0) {
                dp[current][visited] = Math.min(dp[current][visited],
                        solve(next, visited | (1 << next)) + arr[current][next]);
            }
        }

        return dp[current][visited];
    }
}
