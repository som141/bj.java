package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tree {
    static List<Integer> tree[];
    static boolean b[];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        tree= new ArrayList[num+1];

        b= new boolean[num+1];
        for(int i=0;i<=num;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=2;i<=num;i++) {
            String s = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        Queue<Integer> queue = new ArrayList<>();


    }
}
