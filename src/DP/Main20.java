package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main20 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine()); // 사람의 수
        Stack<int[]> stack = new Stack<>(); // 키와 그 키를 가진 사람 수를 저장할 스택
        long pairCount = 0; // 서로 볼 수 있는 쌍의 수

        for (int i = 0; i < num; i++) {
            int height = Integer.parseInt(bufferedReader.readLine()); // 현재 사람의 키
            int count = 1; // 현재 사람의 키와 같은 사람 수

            // 스택이 비어 있지 않고, 현재 사람의 키가 스택의 마지막 사람의 키보다 크거나 같으면
            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                pairCount += stack.peek()[1]; // 스택에 있는 사람들과 서로 볼 수 있음
                if (stack.peek()[0] == height) { // 같은 키를 가진 사람을 만나면
                    count += stack.pop()[1]; // 같은 키를 가진 사람 수를 합침
                } else {
                    stack.pop(); // 키가 작은 사람은 스택에서 제거
                }
            }

            // 스택이 비어 있지 않으면, 현재 사람은 스택의 마지막 사람과 서로 볼 수 있음
            if (!stack.isEmpty()) {
                pairCount++;
            }


            stack.push(new int[]{height, count});
        }

        System.out.println(pairCount);
    }
}