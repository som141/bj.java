package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 해킹 {
    static int caseN;
    static int nodeN;
    static int gN;
    static int firstN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        caseN= Integer.parseInt(br.readLine());
        for(int i=0;i<caseN;i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            nodeN = Integer.parseInt(st.nextToken());
            gN = Integer.parseInt(st.nextToken());
            firstN = Integer.parseInt(st.nextToken());

        }
    }
    static int Dstra(){
        int res=0;
        return res;
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
