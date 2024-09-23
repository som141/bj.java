package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    static int indegree[];
    static List<Integer> w[];
    static int num;
    static int result[];
    static int []cost;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(bufferedReader.readLine());
        w=new ArrayList[num+1];
        indegree=new int[num+1];
        result=new int[num+1];
        cost=new int[num+1];
        for (int i = 1; i <= num; i++) {
            w[i] = new ArrayList<>();
        }
        for(int i=1;i<=num;i++){
            int c=-2;
            String s=bufferedReader.readLine();
            StringTokenizer stringTokenizer=new StringTokenizer(s);
            cost[i]=Integer.parseInt(stringTokenizer.nextToken());
            while(c!=-1){
                c=Integer.parseInt(stringTokenizer.nextToken());
                if(c!=-1){
                    indegree[i]++;
                    w[c].add(i);
                }
            }

        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=num;i++){
            if(indegree[i]==0){
                q.add(i);
                result[i]=cost[i];

            }
        }
        while(!q.isEmpty()){
            int currentV=q.poll();
            for (int next:w[currentV]){
                indegree[next]--;
                result[next]=Math.max(result[next],cost[next]+result[currentV]);
                if(indegree[next]==0){
                    q.add(next);
                }
            }

        }
        for(int i=1;i<=num;i++){
            System.out.println(result[i]);
        }
    }
}
