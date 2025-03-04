package goldRandomDepense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            System.out.println(solve(s));
        }
    }

    private static int solve(String s) {
        if (isPalindrome(s, 0, s.length() - 1)) return 0; // 완전한 회문

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)){
                if(isPalindrome(s, left+1, right)||isPalindrome(s, left, right-1)) {
                    return 1;
                }else return 2;
            }
            left++;
            right--;
        }
        return 2;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
