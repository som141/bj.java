package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main28 {
    static int num; // 도시 크기
    static int num2; // 사건 개수
    static int[][] dp; // DP 테이블
    static int[][] events; // 사건의 위치를 저장
    static int[][] path; // 경로 추적 테이블
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine()); // 도시 크기
        num2 = Integer.parseInt(br.readLine()); // 사건 개수
        events = new int[num2 + 1][2]; // 사건의 위치
        dp = new int[num2 + 1][num2 + 1]; // DP 테이블
        path = new int[num2 + 1][num2 + 1]; // 경로 추적 테이블

        for (int i = 0; i <= num2; i++) {
            for (int j = 0; j <= num2; j++) {
                dp[i][j] = -1; // 초기화: 아직 계산되지 않음
            }
        }

        for (int i = 1; i <= num2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            events[i][0] = Integer.parseInt(st.nextToken());
            events[i][1] = Integer.parseInt(st.nextToken());
        }

        // 최소 거리 출력
        System.out.println(solve(0, 0));

        // 어떤 경찰차가 각 사건을 처리했는지 출력
        printPath(0, 0);
    }

    static int solve(int car1, int car2) {
        int next = Math.max(car1, car2) + 1; // 다음 처리해야 할 사건 번호
        if (next > num2) return 0; // 모든 사건 처리 완료

        if (dp[car1][car2] != -1) return dp[car1][car2]; // 이미 계산된 경우

        // 경찰차 1이 사건 처리
        int distance1 = (car1 == 0) ?
                getDistance(1, 1, events[next][0], events[next][1]) :
                getDistance(events[car1][0], events[car1][1], events[next][0], events[next][1]);

        // 경찰차 2가 사건 처리
        int distance2 = (car2 == 0) ?
                getDistance(num, num, events[next][0], events[next][1]) :
                getDistance(events[car2][0], events[car2][1], events[next][0], events[next][1]);

        // DP 상태 갱신 및 경로 추적
        if (solve(next, car2) + distance1 <= solve(car1, next) + distance2) {
            dp[car1][car2] = solve(next, car2) + distance1;
            path[car1][car2] = 1; // 경찰차 1이 사건 처리
        } else {
            dp[car1][car2] = solve(car1, next) + distance2;
            path[car1][car2] = 2; // 경찰차 2가 사건 처리
        }

        return dp[car1][car2];
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2); // 맨해튼 거리 계산
    }

    static void printPath(int car1, int car2) {
        int next = Math.max(car1, car2) + 1; // 다음 처리해야 할 사건 번호
        if (next > num2) return; // 모든 사건 처리 완료

        // 어떤 경찰차가 처리했는지 출력
        if (path[car1][car2] == 1) {
            System.out.println (1);
            printPath(next, car2); // 경찰차 1의 상태 갱신
        } else {
            System.out.println(2);
            printPath(car1, next); // 경찰차 2의 상태 갱신
        }
    }
}
