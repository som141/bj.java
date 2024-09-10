package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int count;
    static List<node>[]w;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<num;i++){
            String s= bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s," ");
            int num1 = Integer.parseInt(stringTokenizer.nextToken());
            int num2 = Integer.parseInt(stringTokenizer.nextToken());
            int num3 = Integer.parseInt(stringTokenizer.nextToken());
            w= new ArrayList[num1];
            for(int j=0;j<num3;j++){
                String s1= bufferedReader.readLine();
                StringTokenizer stringTokenizer1 = new StringTokenizer(s1," ");
                int n1 = Integer.parseInt(stringTokenizer1.nextToken());
                int n2 = Integer.parseInt(stringTokenizer1.nextToken());
                w[n1].add(new node(n2));
            }
            for(int j=0;j<num1;j++) {
                Queue<node> queue = new PriorityQueue<>(w[j]);
            }
        }
    }
    static class node{
        int v;
        boolean b;

        public node(int v) {
            this.v = v;
            this.b = false;
        }
        public void change(){
            this.b=true;
        }
    }
}
