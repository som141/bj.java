package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main30 {
    static int num;
    static int []arrays;
    static int [][]dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(br.readLine());
        arrays=new int[num+1];
        dp= new int[num+1][num+1];
        String s= br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for(int i=1;i<=num;i++){
            arrays[i]=Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i],-1);
        }
        Arrays.fill(dp[0],-1);

        int result=solve(0,0);
        System.out.println(result);


    }

    private static int solve(int a, int b) {

        int next= Math.max(a,b)+1;//다음 음반 번호
        if(next>num) return 0;//사건 처리 완료
        if(dp[a][b]!=-1) return dp[a][b];
        int df1=(a==0)?0:getD(arrays[a],arrays[next]);
        int df2=(b==0)? 0:getD(arrays[b],arrays[next]);

        if(solve(next,b)+df1<=solve(a,next)+df2){
            dp[a][b]=solve(next,b)+df1;
        }else{
            dp[a][b]=solve(a,next)+df2;
        }


        return dp[a][b];
    }

    private static int getD(int array, int array1) {
        return Math.abs(array-array1);
    }
}
