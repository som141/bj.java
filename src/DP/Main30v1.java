package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main30v1 {
    static int num;
    static int[] arrays;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        arrays = new int[num + 1];
        dp = new int[num + 1][2]; // [0]: 이전 음반, [1]: 현재 음반

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= num; i++) {
            arrays[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화
        for (int i = 0; i <= num; i++) {
            Arrays.fill(dp[i], 10_000_000); // 적당한 큰 값으로 초기화
        }
        dp[0][0] = 0;

        // DP 계산 (2중 루프)
        for (int next = 1; next <= num; next++) {
            int[][] newDp = new int[num + 1][2]; // 새 상태 저장
            for (int[] row : newDp) Arrays.fill(row, 10_000_000);

            for (int a = 0; a < next; a++) {
                if (dp[a][1] != 10_000_000) { // 유효한 상태만 갱신
                    newDp[next][0] = Math.min(newDp[next][0], dp[a][1] + getD(arrays[a], arrays[next]));
                    newDp[a][1] = Math.min(newDp[a][1], dp[a][1] + getD(arrays[a], arrays[next]));
                }
            }
            dp = newDp; // 새 상태로 갱신
        }

        // 최종 결과 계산
        int result = 10_000_000;
        for (int i = 0; i <= num; i++) {
            result = Math.min(result, Math.min(dp[i][0], dp[i][1]));
        }
        System.out.println(result);
    }

    private static int getD(int a, int b) {
        return (a == 0 || b == 0) ? 0 : Math.abs(a - b);
    }
}
