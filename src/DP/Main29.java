package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main29 {
    static int x;
    static int y;
    static int[][] graph;
    static int[][] dp;
    static int[] dx = {1, 0, -1, 0}; // 아래, 오른쪽, 위, 왼쪽
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s1);
        x = Integer.parseInt(st2.nextToken());
        y = Integer.parseInt(st2.nextToken());
        graph = new int[x + 1][y + 1];
        dp = new int[x + 1][y + 1];

        // 그래프 입력
        for (int i = 1; i <= x; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 1; j <= y; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // DP 배열 초기화
            }
        }

        // 시작점 (1, 1)에서 끝점 (x, y)까지의 경로 수 출력
        System.out.println(solve(1, 1));
    }

    private static int solve(int x1, int y1) {
        // 목적지에 도달한 경우
        if (x1 == x && y1 == y) {
            return 1;
        }

        // 이미 계산된 경우
        if (dp[x1][y1] != -1) {
            return dp[x1][y1];
        }

        dp[x1][y1] = 0; // 초기화

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x1 + dx[i];
            int ny = y1 + dy[i];

            // 경계 조건 및 내리막길 조건
            if (nx >= 1 && nx <= x && ny >= 1 && ny <= y && graph[x1][y1] > graph[nx][ny]) {
                dp[x1][y1] += solve(nx, ny);
            }
        }

        return dp[x1][y1];
    }
}
