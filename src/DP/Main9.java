package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9 {
    static int dp[];
    static int w[];
    static int sum;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        dp = new int[num + 1];
        w = new int[num+1];
        String line = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
        for (int i = 1; i <= num; i++) {
            dp[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int result=0;
        for(int i=1; i<=num;i++){
            w[i]=1;
            for(int j=1;j<i;j++){
                if(dp[i]<dp[j]){
                    w[i]=Math.max(w[j]+1,w[i]);
                }
            }
            result= Math.max(result,w[i]);
        }
        System.out.println(result);


    }
}
