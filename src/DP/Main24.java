package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main24 {
    static int[] array;
    static int num;
    static int []jull;
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(br.readLine());
        array = new int[501];
        jull = new int[num];
        dp = new int[num];
        for(int i = 0; i < num; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int num1= Integer.parseInt(st.nextToken());
            int num2= Integer.parseInt(st.nextToken());
            array[num1] =num2;
            jull[i] =num1;
        }
        Arrays.sort(jull);
        System.out.println(num-LIS());

    }

    private static int LIS() {
        int result=0;
        Arrays.fill(dp,1);
        for(int i = 0; i < num; i++){
            for(int j = 0; j < i; j++){
                if(array[jull[i]]>array[jull[j]]){
                    dp[i]= Math.max(dp[i],dp[j]+1);

                }
            }
            result = Math.max(result,dp[i]);
        }

        return result;
    }
}
