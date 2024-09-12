package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);
        String number = bufferedReader.readLine();
        Stack<Character> stack = new Stack<>();
        int act= n2;
        for(int i=0;i<n1;i++){
            char currentC= number.charAt(i);
            while(!stack.isEmpty()&&act>0&&currentC>stack.peek()){
                stack.pop();
                act--;
            }
            stack.push(currentC);

        }
        for(int i=0;i<act;i++){
            stack.pop();
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        System.out.println(result);
    }
}
