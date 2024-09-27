package BF;

import java.io.*;
import java.util.*;

public class domino {
    static List<Integer>[] graph, reverseGraph;
    static boolean[] visited;
    static Stack<Integer> stack;
    static List<List<Integer>> sccs;
    static int[] sccId, indegree;
    static int sccCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int t = 0; t < testCases; t++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());

            graph = new ArrayList[num + 1];
            reverseGraph = new ArrayList[num + 1];
            for (int i = 1; i <= num; i++) {
                graph[i] = new ArrayList<>();
                reverseGraph[i] = new ArrayList<>();
            }

            for (int i = 0; i < edges; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                reverseGraph[b].add(a);
            }

            sccs = new ArrayList<>();
            visited = new boolean[num + 1];
            stack = new Stack<>();

            for (int i = 1; i <= num; i++) {
                if (!visited[i]) dfs(i);
            }

            visited = new boolean[num + 1];
            sccId = new int[num + 1];
            sccCount = 0;

            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (!visited[node]) {
                    sccs.add(new ArrayList<>());
                    reverseDfs(node, sccCount++);
                }
            }

            indegree = new int[sccCount];
            Set<String> addedEdges = new HashSet<>();

            for (int i = 1; i <= num; i++) {
                for (int neighbor : graph[i]) {
                    if (sccId[i] != sccId[neighbor]) {
                        String edgeKey = sccId[i] + "-" + sccId[neighbor];
                        if (!addedEdges.contains(edgeKey)) {
                            indegree[sccId[neighbor]]++;
                            addedEdges.add(edgeKey);
                        }
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < sccCount; i++) {
                if (indegree[i] == 0) result++;
            }

            System.out.println(result);
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) dfs(next);
        }
        stack.push(node);
    }

    static void reverseDfs(int node, int id) {
        visited[node] = true;
        sccId[node] = id;
        sccs.get(id).add(node);

        for (int next : reverseGraph[node]) {
            if (!visited[next]) reverseDfs(next, id);
        }
    }
}
