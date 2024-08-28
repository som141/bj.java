package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class test3 {
    final static PriorityQueue<Integer> rowH = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<num;i++){
            int q= Integer.parseInt(bufferedReader.readLine());
            if(q==0){
                if(rowH.isEmpty()){
                    System.out.println(0);
                    continue;
                }
                System.out.println(rowH.poll());
            }
            if(q!=0){
                rowH.add(q);
            }
        }

    }
}
