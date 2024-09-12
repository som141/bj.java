package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2DFS {
    //시도는 좋은데 최선의 결과는 아님.. 반례가 있음..
    //제대로 dfs,bfs를 쓰자!
    static int count;
    static int[][]w;
    static boolean[][]visit;
    static int x[]={1,-1,0,0};
    static int y[]={0,0,1,-1};
    static int x1;
    static int y1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<num;i++){
            String s= bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s," ");
            int num1 = Integer.parseInt(stringTokenizer.nextToken());
            int num2 = Integer.parseInt(stringTokenizer.nextToken());
            int num3 = Integer.parseInt(stringTokenizer.nextToken());
            w= new int[num1][num2];
            visit=new boolean[num1][num2];
            x1=num1;
            y1=num2;
            for(int j=0;j<num3;j++){
                String s1= bufferedReader.readLine();
                StringTokenizer stringTokenizer1 = new StringTokenizer(s1," ");
                int n1 = Integer.parseInt(stringTokenizer1.nextToken());
                int n2 = Integer.parseInt(stringTokenizer1.nextToken());
                w[n1][n2]=1;
            }
            count=0;
            for(int j=0;j<num1;j++){
                for(int k=0;k<num2;k++){
                    if(w[j][k]==1&&!visit[j][k]){
                        dfs(j,k);
                        count++;
                    }
                }
            }
            System.out.println(count);



        }

    }

    private static void dfs(int j, int k) {
        visit[j][k]=true;
        for(int i=0;i<4;i++){
            int nx=x[i]+j;
            int ny=y[i]+k;

            if(nx>=0&&nx<x1&&ny>=0&&ny<y1){
                if(w[nx][ny]==1&&!visit[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }

    }


}