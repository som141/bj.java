package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1 {
    static List<tree.Tree>tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        tree=new ArrayList[num1+1];
        for(int i=1;i<=num1;i++){
            tree[i]=new ArrayList<>();
            String line=br.readLine();
            StringTokenizer st=new StringTokenizer(line);
            char data = st.nextToken().charAt(0);
            char left=st.nextToken().charAt(0);
            char right=st.nextToken().charAt(0);
            tree[i].add(new tree.Tree(data,left,right));
        }



    }
    static class Tree{
        private char data;
        private char left;
        private char right;

        public Tree(char data, char left, char right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
