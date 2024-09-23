package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static List<Integer>[] w;
    static int[] indoor;
    static int num;
    static int caseN;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line=bufferedReader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        num = Integer.parseInt(tokenizer.nextToken());
        caseN = Integer.parseInt(tokenizer.nextToken());
        result = new ArrayList<>();
        w = new ArrayList[num+1];
        indoor=new int[num+1];
        for (int i=1;i<=num;i++){
            w[i] = new ArrayList<>();
        }
        for(int i=1;i<=caseN;i++){
            String s = bufferedReader.readLine();
            StringTokenizer tokenizer1 = new StringTokenizer(s);
            int a = Integer.parseInt(tokenizer1.nextToken());
            int b = Integer.parseInt(tokenizer1.nextToken());
            w[a].add(b);
            indoor[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1;i<=num;i++){
            if(indoor[i]==0){
                pq.add(i);
            }
        }
        while (!pq.isEmpty()){
            int CurrentV = pq.poll();
            result.add(CurrentV);
            for(int next:w[CurrentV]){
                indoor[next]--;
                if(indoor[next]==0){
                    pq.add(next);
                }
            }

        }
        for(int r:result){
            System.out.print(r+" ");
        }


    }
}
