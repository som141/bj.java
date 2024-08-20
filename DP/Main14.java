package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14 {
    static int[] dp;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < num; i++) {
            int num1 = Integer.parseInt(bufferedReader.readLine());
            dp = new int[num1 + 1];
            String s = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s, " ");

            for (int j = 1; j <= num1; j++) {
                dp[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            result = 0;  // 각 테스트 케이스 시작 시 result 초기화
            int l = num1;

            while (l > 1) {
                int min = dp[1] + dp[2];
                int n = 1;

                for (int j = 1; j < l; j++) {
                    if (min > dp[j] + dp[j + 1]) {
                        min = dp[j] + dp[j + 1];
                        n = j;
                    }
                }

                dp[n] = min;
                result += min;

                // dp 배열 요소들을 왼쪽으로 이동
                for (int j = n + 1; j < l; j++) {
                    dp[j] = dp[j + 1];
                }

                l--; // 배열 크기 감소
            }

            System.out.println(result);
        }
    }
}