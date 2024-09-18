package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main20 {
    static int num;
    static int []w;
    static int []dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(bufferedReader.readLine());
        w=new int[num+1];
        dp=new int[num+1];
        for(int i=1;i<=num;i++){
            int k=Integer.parseInt(bufferedReader.readLine());
            w[i]=k;
        }
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=num;i++){
            Stack<Integer> stack=new Stack<>();
            for(int j=1;j<i;j++){
                if(w[i]<w[j]){
                    stack.push(j);
                }
            }
            int k1=1;
            if(!stack.isEmpty()){
                k1=stack.pop();
            }
            dp[i]=dp[i-1]+i-k1-1;
        }
        System.out.println(dp[num]);
    }
}
