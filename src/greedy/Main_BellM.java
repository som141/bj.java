package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BellM {
    static List<graph> g=new ArrayList<graph>();
    static int num;
    static int caseN;
    static long []d;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);
        num=Integer.parseInt(st.nextToken());
        caseN=Integer.parseInt(st.nextToken());
        d=new long[num+1];
        for(int i=1;i<=caseN;i++){
            String s1=br.readLine();
            st=new StringTokenizer(s1);
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            g.add(new graph(a,b,c));
        }
        BellM(1);

        }
        static void BellM(int k){
            for(int i=1;i<=num;i++){
                d[i]=Long.MAX_VALUE;
            }
            d[k]=0;
            for(int i=1;i<num;i++){
                for(graph g1:g){
                    int u=g1.u;
                    int v=g1.v;
                    int cost=g1.cost;
                    if(d[u]!=Long.MAX_VALUE&&d[u]+cost<d[v]){
                        d[v]=d[u]+cost;
                    }
                }
            }

            for(graph g1:g){
                int u=g1.u;
                int v=g1.v;
                int cost=g1.cost;
                if(d[u]!=Long.MAX_VALUE&&d[u]+cost<d[v]){
                    System.out.println(-1);
                    return;
                }
            }
            for(int i=2;i<=num;i++){
                if(d[i]==Long.MAX_VALUE){
                    System.out.println(-1);
                }
                else {
                    System.out.println(d[i]);
                }
            }
        }



    static class graph{
        int u;
        int v;
        int cost;

        public graph(int u,int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }}


