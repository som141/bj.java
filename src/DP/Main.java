package DP;

public class Main {
   public static int[][] mutiple(int [][] a1,int [][] a2){
       int answer[][]=new int[a1.length][a2[0].length];
       int i=0;
       int j=0;
       int k=0;
       for(i=0;i<answer.length;i++){
           for(j=0;j<answer[0].length;i++){
               for (k=0;k<a2.length;k++){
                   answer[i][j]+=a1[i][k]*a2[k][j];
               }
           }
       }

       return answer;
   }
}