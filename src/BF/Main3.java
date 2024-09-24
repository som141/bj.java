package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    static List<graph>[] w;
    static List<graph>[] rw;
    static int []result;
    static int []ingreed;
    static int num;
    static int Enum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num=Integer.parseInt(br.readLine());
        Enum=Integer.parseInt(br.readLine());
        w = new List[num+1];
        rw = new List[num+1];
        result = new int[num+1];
        ingreed = new int[num+1];
        for(int i=1;i<=num;i++){
            w[i] = new LinkedList<>();
            rw[i] = new LinkedList<>();
        }
        for(int i=1;i<=Enum;i++){
            String line = br.readLine();
            StringTokenizer st1=new StringTokenizer(line);
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int c = Integer.parseInt(st1.nextToken());
            w[a].add(new graph(b,c));
            rw[b].add(new graph(a,c));
            ingreed[b]++;
        }
        String line = br.readLine();
        StringTokenizer st2=new StringTokenizer(line);
        int a = Integer.parseInt(st2.nextToken());
        int b = Integer.parseInt(st2.nextToken());
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        while(!q.isEmpty()){
            int currentV=q.poll();
            for(graph nextV:w[currentV]){
                ingreed[nextV.v]--;
                if(result[nextV.v]<nextV.cost+result[currentV]){
                    result[nextV.v]=nextV.cost+result[currentV];
                }

                if(ingreed[nextV.v]==0){
                    q.add(nextV.v);
                }
            }
        }
        System.out.println(result[b]);

        int r1 = 0;
        q.clear();
        q.add(b);

        boolean[] visited = new boolean[num + 1];

        while (!q.isEmpty()) {
            int current = q.poll();
            for (graph g : rw[current]) {
                int prev = g.v;
                if (result[current] == result[prev] + g.cost) {
                    r1++;
                    if (!visited[prev]) {
                        q.add(prev);
                        visited[prev] = true;
                    }
                }
            }
        }
        System.out.println(r1);
    }
    static class graph{
        int v;
        int cost;

        public graph(int v, int cost) {

            this.v = v;
            this.cost = cost;
        }
    }

}
