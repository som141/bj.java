package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main5 {
    static int []indegree;
    static List<Integer>[] graph;
    static int num,caseN;
    static List<Integer> adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        num = Integer.parseInt(st.nextToken());
        caseN = Integer.parseInt(st.nextToken());
        graph = new List[num+1];
        indegree = new int[num+1];
        for(int i=1;i<=num;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=caseN;i++){
            String s = br.readLine();
            StringTokenizer st2 = new StringTokenizer(s);
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }
        adjList=new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=num;i++){
            if(indegree[i]==0){
                q.add(i);
                adjList.add(i);
            }
        }
        while(!q.isEmpty()){
            int a = q.poll();
            for(int b : graph[a]){
                indegree[b]--;
                if(indegree[b]==0){
                    q.add(b);
                    adjList.add(b);
                }
            }
        }
        for(int i:adjList){
            System.out.print(i+" ");
        }

    }
}
