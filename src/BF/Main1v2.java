package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1v2 {
    static List<Integer>[] graph;
    static int num,indegreeN;
    static int[]result,costs,indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num=Integer.parseInt(br.readLine());
        graph=new ArrayList[num+1];
        result=new int[num+1];
        costs=new int[num+1];
        indegree=new int[num+1];
        for(int i=1;i<=num;i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= num; i++) {
            String line=br.readLine();
            StringTokenizer st=new StringTokenizer(line);
            costs[i]=Integer.parseInt(st.nextToken());
            indegreeN=Integer.parseInt(st.nextToken());
            indegree[i]=indegreeN;
            for(int j=1;j<=indegreeN;j++){
                int b=Integer.parseInt(st.nextToken());
                graph[b].add(i);
            }

        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=num;i++){
            if(indegree[i]==0){
                q.add(i);
                result[i]=costs[i];
            }
        }
        while(!q.isEmpty()){
            int currentV=q.poll();
            for(int next:graph[currentV]){
                indegree[next]--;
                result[next]=Math.max(costs[next]+result[currentV],result[next]);
                if(indegree[next]==0){
                    q.add(next);
                }
            }


        }
        int Max=0;
        for(int i=1;i<=num;i++){
            Max=Math.max(Max,result[i]);
        }
        System.out.println(Max);


    }

}
