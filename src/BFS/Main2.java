package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        int num1= Integer.parseInt(bufferedReader.readLine());
        int num2= Integer.parseInt(bufferedReader.readLine());
        UnionFind unionFind = new UnionFind(num1);
        for(int i=0;i<num2;i++){
            String s= bufferedReader.readLine();
            StringTokenizer stringTokenizer =new StringTokenizer(s," ");
            int key = Integer.parseInt(stringTokenizer.nextToken());
            int value = Integer.parseInt(stringTokenizer.nextToken());
            unionFind.union(key,value);
        }
        int v= unionFind.find(1);
        for(int i=2;i<=num1;i++){
            if(unionFind.find(i)==v){
                count++;
            }
        }
        System.out.println(count);

    }
    static class UnionFind{
         int n;
        int arrays[];
        int Level[];

        public UnionFind(int n) {
            this.n = n;
            arrays=new int[n+1];
            Level= new int[n+1];
            for(int i=1;i<=n;i++){
                arrays[i]=i;
            }
        }
        public int find(int x){
            if(arrays[x]!=x){
                arrays[x]=find(arrays[x]);
            }
            return arrays[x];
        }
        public void union(int key, int value){
            int rootX=find(key);
            int rootY=find(value);
            if(Level[rootX]>Level[rootY]){
                arrays[rootY]=rootX;
            }
            else if(Level[rootX]<Level[rootY]){
                arrays[rootX]=rootY;
            }
            else if(Level[rootX]==Level[rootY]){
                arrays[rootY]=rootX;
                Level[rootX]++;
            }

        }
    }
}
