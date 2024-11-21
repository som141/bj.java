package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());


        PriorityQueue<wc> jewelQueue = new PriorityQueue<>();

        PriorityQueue<Integer> bagQueue = new PriorityQueue<>();


        for (int i = 0; i < num1; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            jewelQueue.offer(new wc(w, c));
        }

        // 가방 정보 입력
        for (int i = 0; i < num2; i++) {
            bagQueue.offer(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        PriorityQueue<Integer> availableJewels = new PriorityQueue<>(Comparator.reverseOrder());

        while (!bagQueue.isEmpty()) {
            int currentBag = bagQueue.poll();


            while (!jewelQueue.isEmpty() && jewelQueue.peek().w <= currentBag) {
                availableJewels.offer(jewelQueue.poll().c);
            }


            if (!availableJewels.isEmpty()) {
                sum += availableJewels.poll();
            }
        }


        System.out.println(sum);
    }


    static class wc implements Comparable<wc> {
        int w;
        int c;

        public wc(int w, int c) {
            this.w = w;
            this.c = c;
        }

        @Override
        public int compareTo(wc o) {
            return this.w - o.w;
        }
    }
}
