package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16 {
    static int dp[][];
    static int matrix[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        matrix=new int[num+2];
        dp=new int[num+1][num+1];
        matrix[0]=0;
        for(int i=1;i<num;i++){
            String string=bufferedReader.readLine();
            StringTokenizer stringTokenizer= new StringTokenizer(string," ");
            int sum = Integer.parseInt(stringTokenizer.nextToken());
            matrix[i]=sum;
        }
        String string=bufferedReader.readLine();
        StringTokenizer stringTokenizer= new StringTokenizer(string," ");
        int sum = Integer.parseInt(stringTokenizer.nextToken());
        matrix[num]=sum;
        int sum1 = Integer.parseInt(stringTokenizer.nextToken());
        matrix[num+1]=sum1;
        for(int i=1;i<=num;i++){
            for(int start=1;start+i<=num;start++){
                int end= start+i;
                dp[start][end]=Integer.MAX_VALUE;
                for(int mid=start;mid<end;mid++){
                    dp[start][end]=Integer.min(dp[start][end],dp[start][mid]+dp[mid+1][end]+matrix[start]*matrix[mid+1]
                            *matrix[end+1]);
                }
            }
        }
        System.out.println(dp[1][num]);

    }
}
