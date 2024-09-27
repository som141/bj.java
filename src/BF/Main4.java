package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {
    static List<Integer>[] graph,reverseGraph;
    static int f;
    static int num;
    static int tastC;
    static int[]ingreed;
    static boolean[] visited;
    static Stack<Integer> stack;
    static int result;
    static List<List<Integer>> sccs;
    static int[] sccId;
    static int sccCount;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        f= Integer.parseInt(bufferedReader.readLine());
        for(int as=1; as<=f; as++){
        String line = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        num = Integer.parseInt(stringTokenizer.nextToken());
        tastC = Integer.parseInt(stringTokenizer.nextToken());
        graph = new ArrayList[num+1];
        reverseGraph = new ArrayList[num+1];
        visited = new boolean[num+1];
        stack = new Stack<>();
        sccs = new ArrayList();
        for(int i=1;i<=num;i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for(int i=1;i<=tastC;i++){
            String s = bufferedReader.readLine();
            StringTokenizer stringTokenizer1 = new StringTokenizer(s);
            int a = Integer.parseInt(stringTokenizer1.nextToken());
            int b = Integer.parseInt(stringTokenizer1.nextToken());
            graph[a].add(b);
            reverseGraph[b].add(a);
        }
        sccs = new ArrayList();
        for(int i=1;i<num+1;i++){
            if(!visited[i])dfs(i);
        }
        visited = new boolean[num+1];
        sccId = new int[num+1];
        sccCount = 0;
        while(!stack.isEmpty()){
            int s = stack.pop();
            if(!visited[s]){
                sccs.add(new ArrayList<>());
                reverseDfs(s,sccCount++);
            }
        }
        ingreed=new int[sccCount+1];
            boolean[][] sccEdges = new boolean[sccCount][sccCount];

            for (int i = 1; i <= num; i++) {
                for (int neighbor : graph[i]) {
                    if (sccId[i] != sccId[neighbor]) {
                        if (!sccEdges[sccId[i]][sccId[neighbor]]) {
                            ingreed[sccId[neighbor]]++;
                            sccEdges[sccId[i]][sccId[neighbor]] = true;
                        }
                    }
                }
            }
            result=0;
            for(int i=1;i<=sccCount;i++){
                if(ingreed[i]==0){
                    result++;
                }
            }
            System.out.println(result);
        }



    }
    static void dfs(int node){
        visited[node]=true;
        for(int next:graph[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
        stack.push(node);
    }
    static void reverseDfs(int node,int sccCount){
        visited[node]=true;
        sccId[node]=sccCount;
        sccs.get(sccCount).add(node);
        for(int next:reverseGraph[node]){
            if(!visited[next]){
                reverseDfs(next,sccCount);
            }
        }
    }
}

