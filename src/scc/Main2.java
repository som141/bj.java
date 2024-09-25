package scc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int num;
    static int caseN;
    static List<Integer>[] graph;
    static List<Integer>[] reverseGraph;
    static boolean[] visited;
    static Stack<Integer> stack;
    static List<List<Integer>> sccs;
    static int []sccId;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        num = Integer.parseInt(st.nextToken());
        caseN = Integer.parseInt(st.nextToken());
        graph = new ArrayList[num+1];
        reverseGraph = new ArrayList[num+1];
        visited = new boolean[num+1];
        for(int i=1;i<=num;i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for(int i=1;i<=caseN;i++){
            String s1 = br.readLine();
            StringTokenizer st1 = new StringTokenizer(s1);
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph[a].add(b);
            reverseGraph[b].add(a);
        }
        stack = new Stack<>();
        sccs = new ArrayList();
        for(int i=1;i<=num;i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        visited=new boolean[num+1];
        sccId = new int[num+1];
        int sccCount = 0;
        while(!stack.isEmpty()){
            int s1=stack.pop();
            if(!visited[s1]){
                sccs.add(new ArrayList<>());
                reverseDfs(s1,sccCount++);
            }
        }
        System.out.println(sccCount);
        for (List<Integer> scc : sccs) {
            Collections.sort(scc);
        }

        sccs.sort(Comparator.comparingInt(o -> o.get(0)));
        for(List<Integer> list:sccs){

            for(Integer i:list){
                System.out.print(i+" ");
            }
            System.out.print(-1);
            System.out.println();
        }


    }
    static void dfs(int i){
        visited[i] = true;
        for(int graph:graph[i]){
            if(!visited[graph]){
                dfs(graph);
            }
        }
        stack.push(i);
    }
    static void reverseDfs(int i,int sccCount){
        visited[i] = true;
        sccId[i]=sccCount;
        sccs.get(sccCount).add(i);
        for(int next:reverseGraph[i]){
            if(!visited[next]){
                reverseDfs(next,sccCount);
            }
        }
    }
}
