package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연료채우기 {
    static int caseN;
    static int last;
    static int firstCost;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        caseN = Integer.parseInt(br.readLine());
        node[] list = new node[caseN];

        for (int i = 0; i < caseN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[i] = new node(d, c);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        last = Integer.parseInt(st.nextToken());
        firstCost = Integer.parseInt(st.nextToken());
        Arrays.sort(list, Comparator.comparingInt(a -> a.distance));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int remainCost = firstCost;
        int start = 0;

        while (remainCost < last) {
            while (start < caseN && list[start].distance <= remainCost) {
                pq.add(list[start].cost);
                start++;
            }

            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }

            remainCost += pq.poll();
            result++;
        }

        System.out.println(result);
    }

    static class node {
        int distance;
        int cost;

        public node(int distance, int cost) {
            this.distance = distance;
            this.cost = cost;
        }
    }
}
