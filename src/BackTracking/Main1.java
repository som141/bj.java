package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1 {
    static int n;
    static int[][]array;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        array = new int[n+1][n+1];
        count=0;
        for(int i=0;i<=n;i++){
            Arrays.fill(array[i],0);
        }
        Queens(1);
        System.out.println(count);
    }
    static void Queens(int depth){
           if(depth == n+1){
               count++;
               return;
           }
           for(int i=1;i<=n;i++){
               if(ispromising(depth,i)){
                   array[depth][i] = 1;
                   Queens(depth+1);//위로 올람
                   array[depth][i] = 0;
               }
           }
    }
    static boolean ispromising(int depth, int pos){//유망성 검사
        for(int i=1;i<=depth;i++){
            if(array[i][pos] == 1){
                return false;
            }
        }
        int i= depth;
        int j = pos;
        while(i>0&&j>0){
            if(array[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }
        i= depth;
        j = pos;
        while(i>0&&j<=n){
            if(array[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
