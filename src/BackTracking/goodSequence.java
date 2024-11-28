package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class goodSequence {
    static int num;
    static int[]arrays;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       num= Integer.parseInt(br.readLine());
       arrays = new int[num+1];
       solve(1);
    }
    public static void solve(int n) {
        if(n==num+1){
            for(int i=1;i<=num;i++){
                System.out.print(arrays[i]);
            }
            System.exit(0);
        }
        for(int i=1;i<4;i++) {
            arrays[n] = i;
            if (isPromising(n)) {
                solve(n+1);
            }
            arrays[n] = 0;
        }
    }

    private static boolean isPromising(int n) {
        for (int len = 1; len <= (n + 1) / 2; len++) { // 부분수열 길이
            boolean isSame = true;
            for (int j = 0; j < len; j++) {
                if (arrays[n - j] != arrays[n - len - j]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return false; // 중복된 부분수열 발견
        }
        return true; // 좋은 수열
    }
    }

