package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이 {
    static int N;
    static int M;
    static char[][] board;
    static boolean[][] visited;
    static int[] x1={1,-1,0,0};
    static int[] y1={0,0,1,-1};
    static int[][] r;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        r = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] =line.charAt(j);
            }
        }
        bfs(0,0);
        for (int i = 0; i < N; i++) {
            System.out.println();
            for (int j = 0; j < M; j++) {
                System.out.print(r[i][j]);
            }
        }


    }
    static void bfs(int x, int y) {
        visited[x][y] = true;
        int c=board[x][y];
        for(int i=0;i<4;i++){
            int Nx=x+x1[i];
            int Ny=y+y1[i];
            if(Nx>=0&&Nx<N&&Ny>=0&&Ny<M&&board[Nx][Ny]==board[x][y]){
                if(!visited[Nx][Ny]){
                    r[Nx][Ny]=r[x][y]+1;
                bfs(Nx,Ny);}

            }
            if(Nx>=0&&Nx<N&&Ny>=0&&Ny<M&&board[Nx][Ny]!=board[x][y]&&!visited[Nx][Ny]){
                visited[Nx][Ny]=true;
                r[Nx][Ny]++;
                bfs(Nx,Ny);

            }
        }

    }
}
