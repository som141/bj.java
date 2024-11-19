package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main5 {
    static int num;
    public static void main(String[] args) throws IOException {
        Queue<Integer> q=new PriorityQueue<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
            q.add(Integer.parseInt(br.readLine()));
        }
        int sum=0;
        while(q.size()!=1){
            int a=q.poll();
            int b=q.poll();
            int c=a+b;
            sum+=c;
            q.add(c);
        }
        System.out.println(sum);

    }
}
