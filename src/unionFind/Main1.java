package unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int n;
    static int p;
    static int[]graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        graph = new int[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = i;
        }
        String s2= br.readLine();
        st = new StringTokenizer(s2);
        int c= Integer.parseInt(st.nextToken());
        for(int i=1;i<=c;i++){
            int u= Integer.parseInt(st.nextToken());
        }
    }
    static void find(){

    }
    static void union(int a, int b) {

    }

}
