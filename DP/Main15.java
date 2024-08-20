package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15 {

    static int dp[][];
    static int files[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < num; i++) {
            int num1 = Integer.parseInt(bufferedReader.readLine());
            files = new int[num1 + 1];
            dp = new int[num1 + 1][num1 + 1];
            String s = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
            int sum = 0;
            files[0]=0;
            for (int j = 1; j <= num1; j++) {
                sum=Integer.parseInt(stringTokenizer.nextToken());

                files[j] = sum+files[j-1];
            }

            for(int j=1;j<num1;j++){
                for(int st=1; st+j<=num1;st++){
                    int end= st+j;
                    dp[st][end]=Integer.MAX_VALUE;

                    for(int mid =st;mid<end;mid++){
                        dp[st][end]= Math.min(dp[st][end],dp[st][mid]+dp[mid+1][end]+files[end]-files[st-1]);
                    }
                }

            }
            System.out.println(dp[1][num1]);
        }
    }
}
