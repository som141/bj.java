package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int count;
    static int[][]w;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<num;i++){
            count=0;
            String s= bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s," ");
            int num1 = Integer.parseInt(stringTokenizer.nextToken());
            int num2 = Integer.parseInt(stringTokenizer.nextToken());
            int num3 = Integer.parseInt(stringTokenizer.nextToken());
            w= new int[num1][num2];
            Queue<node> queue= new PriorityQueue<>();
            for(int j=0;j<num3;j++){
                String s1= bufferedReader.readLine();
                StringTokenizer stringTokenizer1 = new StringTokenizer(s1," ");
                int n1 = Integer.parseInt(stringTokenizer1.nextToken());
                int n2 = Integer.parseInt(stringTokenizer1.nextToken());
                w[n1][n2]=1;
                queue.add(new node(n1,n2));
            }
            for(int j=0;j<num3;j++){
                node n= queue.poll();
                if(w[n.u][n.v]==1){
                    count++;
                }
                if(n.u>0&&w[n.u-1][n.v]==1){
                    w[n.u-1][n.v]=0;
                }
                if(n.u<num1-1&&w[n.u+1][n.v]==1){
                    w[n.u+1][n.v]=0;
                }
                if(n.v>0&&w[n.u][n.v-1]==1){
                    w[n.u][n.v-1]=0;
                }
                if(n.v<num2-1&&w[n.u][n.v+1]==1){
                    w[n.u][n.v+1]=0;
                }


            }
            System.out.println(count);


        }

    }
    static class node implements Comparable<node>{
        int u;
        int v;

        public node(int u,int v) {
            this.u = u;
            this.v = v;
        }


        @Override
        public int compareTo(node o) {
            return (this.u+this.v)-(o.u+o.v);
        }
    }

}