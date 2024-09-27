package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main19 {
    static int num;;
    static int []indegree;
    static List<Integer>[] w,rw;
    static int[]costs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(br.readLine());
        indegree= new int[num+1];
        w=new ArrayList[num+1];
        rw=new ArrayList[num+1];
        costs=new int[num+1];
        for (int i = 1; i <= num; i++) {
            w[i] = new ArrayList<>();
        }
        for(int i=1;i<=num;i++){
            String line=br.readLine();
            StringTokenizer st=new StringTokenizer(line);
            int cost=Integer.parseInt(st.nextToken());
            costs[i]=cost;
            int n=Integer.parseInt(st.nextToken());
            for(int j=1;j<=n;j++){
                int k=Integer.parseInt(st.nextToken());
                w[k].add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> pq=new LinkedList<>();
        int []result= new int[num+1];

        for(int i=1;i<=num;i++){
            if(indegree[i]==0){
                pq.add(i);
                result[i]=costs[i];
            }
        }

        while(!pq.isEmpty()){
            int current =pq.poll();

            for (int next : w[current]){
                indegree[next]--;
                result[next]=Math.max(result[next],result[current]+costs[next]);
                if(indegree[next]==0){
                pq.add(next);}
            }
        }

        int answer=0;
        for(int i=1;i<=num;i++){
            answer=Math.max(answer,result[i]);
            System.out.println(result[i]);
        }

        System.out.println(answer);


    }
}
