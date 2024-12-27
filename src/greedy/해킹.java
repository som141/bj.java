package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 해킹 {
    static int caseN;
    static int nodeN;
    static int gN;
    static int firstN;
    static List<node> []g;
    static int[]result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        caseN= Integer.parseInt(br.readLine());
        for(int i=0;i<caseN;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            nodeN = Integer.parseInt(st.nextToken());
            gN = Integer.parseInt(st.nextToken());
            firstN = Integer.parseInt(st.nextToken());
            g = new ArrayList[nodeN+1];
            for(int i1=1; i1<=nodeN; i1++){
                g[i1] = new ArrayList<>();
            }
            result = new int[nodeN+1];
            visited = new boolean[nodeN+1];
            for(int j=0;j<gN;j++){
                String s = br.readLine();
                StringTokenizer st2 = new StringTokenizer(s);
                int u = Integer.parseInt(st2.nextToken());
                int v = Integer.parseInt(st2.nextToken());
                int c = Integer.parseInt(st2.nextToken());
                g[v].add(new node(u, c));
            }
            Arrays.fill(result,999999999);
            Arrays.fill(visited,false);
            result[firstN] = 0;
            Dstra(result,firstN);
            int count=0;
            int max=0;
            for(int j=1;j<nodeN+1;j++){
                if(visited[j]){
                    count++;
                    max = Math.max(max, result[j]);
                }
            }
            System.out.println(count+" "+max);


        }
    }
    static void Dstra(int[]result,int start){
        Queue<node> pq= new PriorityQueue<>();
        pq.add(new node(start,0));
        while(!pq.isEmpty()){
            node temp = pq.poll();
            int currentV=temp.v;
            int currentC=temp.c;

            if(visited[currentV]){
                continue;
            }
            visited[currentV] = true;
            for(node Next:g[currentV]){
                if(result[Next.v] > currentC + Next.c) {
                    result[Next.v] = currentC + Next.c;
                    pq.add(new node(Next.v, result[Next.v]));
                }


            }

        }
    }
    static class node implements Comparable<node> {
        int v;
        int c;

        public node(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(node o) {
            return this.c - o.c;
        }
    }
}
