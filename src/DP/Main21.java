package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main21 {
    static int[] jull;
    static int num;
    static boolean []b;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(br.readLine());
        jull = new int[501];
        for(int i = 1; i <= num; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            jull[a]=b;
        }
        int count1=0;
        for(int i = 2; i <= 500; i++){

                if (jull[i] < jull[i - 1]) {
                    if(jull[i]!=0){
                        count1++;
                    }
                    jull[i] = jull[i - 1];

                }

        }
        int count2=0;
        for(int i=499; i >=1; i--){
            if(jull[i]==0){
                jull[i]=jull[i+1];
            }
            if (jull[i+1] < jull[i]) {
                if(jull[i+1]!=0){
                    count2++;
                    jull[i] = jull[i+1];
                }

            }
        }
        System.out.println(Math.min(count1,count2));

    }

}
