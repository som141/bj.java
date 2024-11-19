package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main26 {
    static int N;
    static int []arr;
    static int []dp;
    public static void main(String[] args) throws IOException {
        int result=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        String line = br.readLine();
        StringTokenizer st= new StringTokenizer(line);
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,1);
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }

            }
            result=Math.max(result,dp[i]);
        }
        System.out.println(result);
    }
}
