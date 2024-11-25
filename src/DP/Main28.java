package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main28 {
    static int num;
    static int num2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        num2 = Integer.parseInt(br.readLine());
        dp = new int[2][num2 + 1];
        graph1[][] graph = new graph1[2][num2 + 1];

        // 초기 위치 설정
        graph[0][0] = new graph1(1, 1);  // 경찰차 1 초기 위치
        graph[1][0] = new graph1(num, num);  // 경찰차 2 초기 위치

        Queue<graph1> q = new LinkedList<>();
        for (int i = 0; i < num2; i++) {
            String s1 = br.readLine();
            StringTokenizer st = new StringTokenizer(s1, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.offer(new graph1(x, y));
        }

        for (int i = 1; i <= num2; i++) {
            graph1 g = q.poll();  // 현재 사건 위치
            int x = g.x;
            int y = g.y;

            for (int j = 0; j < 2; j++) {
                // 이전 경찰차의 위치와 현재 사건 간 거리 계산
                int prev1 = dp[0][i - 1] + (Math.abs(graph[0][i - 1].x - x) + Math.abs(graph[0][i - 1].y - y));
                int prev2 = dp[1][i - 1] + (Math.abs(graph[1][i - 1].x - x) + Math.abs(graph[1][i - 1].y - y));
                dp[j][i] = Math.min(prev1, prev2);

                // 그래프 위치 갱신
                if (prev1 < prev2) {
                    graph[j][i] = new graph1(x, y); // 경찰차 1이 사건을 처리
                } else {
                    graph[j][i] = graph[j][i - 1]; // 경찰차 2가 처리
                }
            }
        }

        int result = Math.min(dp[0][num2], dp[1][num2]);
        System.out.println(result);
    }

    static class graph1 {
        int x;
        int y;

        public graph1(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
