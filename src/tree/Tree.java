package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tree {
    static Queue<Integer> tree[];
    static boolean b[];
    static int []d;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        tree= new LinkedList[num+1];


        b= new boolean[num+1];
        d= new int[num+1];
        for(int i=0;i<=num;i++){
            tree[i]=new LinkedList<>();
        }
        for(int i=2;i<=num;i++) {
            String s = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        b[1]=true;
        while(!queue.isEmpty()){
            int v= queue.poll();
            for(int k :tree[v]){
                if(!b[k]){
                    d[k]=v;
                    b[k]=true;
                    queue.add(k);
                }
            }
        }
        for(int i=2;i<=num;i++){
            System.out.println(d[i]);
        }




    }
}
