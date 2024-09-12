package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1 {
    static int n1;
    static int n2;
    static int[]nx={-1,1,0,0};
    static int[]ny={0,0,-1,1};
    static int [][]w;// 미로를 나타내줌
    static boolean[][]b;//방문 지점 표시
    static int [][]distance;//dp 느낌으로 가는 거리를 직접 출력 할 수도 있다.
    static Queue<graph> queue;//담을 큐
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        String s1= bufferedReader.readLine();
        StringTokenizer stringTokenizer =new StringTokenizer(s1," ");
        n1= Integer.parseInt(stringTokenizer.nextToken());
        n2= Integer.parseInt(stringTokenizer.nextToken());
        w= new int[n1][n2];
        b= new boolean[n1][n2];
        distance= new int[n1][n2];
        queue= new LinkedList<>();
        for(int i=0; i<n1;i++){
            String s= bufferedReader.readLine();
            for(int j=0;j<n2;j++){
                w[i][j] = s.charAt(j) - '0';
            }
        }
        queue.add(new graph(0,0));
        bfs();



    }

    private static void bfs() {
        while (!queue.isEmpty()) {

            graph g1= queue.poll();
            for(int i=0;i<4;i++){
                int xx= nx[i]+ g1.x;
                int yy= ny[i]+ g1.y;

                if(xx>=0&&xx<n1&&yy>=0&&yy<n2){
                    if(w[xx][yy]==1&&!b[xx][yy]){
                        queue.add(new graph(xx,yy));
                        b[xx][yy]=true;
                        distance[xx][yy]=distance[g1.x][g1.y]+1;
                    }
                }
            }
        }
        System.out.println(distance[n1-1][n2-1]+1);

    }

    static class graph{
        int x;
        int y;

        public graph(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
