package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {
    static List<Integer>[] graph;
    static int f;
    static int num;
    static int tastC;
    static int[]ingreed;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        f= Integer.parseInt(bufferedReader.readLine());
        for(int as=1; as<=f; as++){
        String line = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        num = Integer.parseInt(stringTokenizer.nextToken());
        tastC = Integer.parseInt(stringTokenizer.nextToken());
        graph = new ArrayList[num+1];
        ingreed = new int[num+1];
        for(int i=1;i<=num;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=tastC;i++){
            String s = bufferedReader.readLine();
            StringTokenizer stringTokenizer1 = new StringTokenizer(s);
            int a = Integer.parseInt(stringTokenizer1.nextToken());
            int b = Integer.parseInt(stringTokenizer1.nextToken());
            graph[a].add(b);
            ingreed[b]++;
        }
        result = 0;
        Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[num + 1];
            int result = 0;

            // 진입 차수가 0인 도미노를 먼저 큐에 삽입
            for (int i = 1; i <= num; i++) {
                if (ingreed[i] == 0) {
                    queue.offer(i);
                    visited[i] = true;
                    result++;  // 이 도미노는 손으로 넘어뜨려야 함
                }
            }

            // 위상 정렬 진행
            while (!queue.isEmpty()) {
                int current = queue.poll();

                // 현재 도미노와 연결된 도미노들 처리
                for (int neighbor : graph[current]) {
                    ingreed[neighbor]--;
                    if (ingreed[neighbor] == 0 && !visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }

            System.out.println(result);
        }

    }
}

