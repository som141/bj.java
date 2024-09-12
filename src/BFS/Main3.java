package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    static int [][][] tomato;
    static Queue<G> queue;
    static boolean [][][] b;
    static int count[][][];
    static int x;
    static int y;
    static int z;
    static int[]nx={-1,1,0,0,0,0};
    static int[]ny={0,0,-1,1,0,0};
    static int[]nz={0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        String s1=bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s1," ");
        z= Integer.parseInt(stringTokenizer.nextToken());
        y= Integer.parseInt(stringTokenizer.nextToken());
        x= Integer.parseInt(stringTokenizer.nextToken());

        tomato= new int[x][y][z];
        queue= new LinkedList<>();
        b=new boolean[x][y][z];
        count=new int[x][y][z];
        int b2=0;
        int b3=0;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                String s2=bufferedReader.readLine();
                StringTokenizer stringTokenizer1 = new StringTokenizer(s2," ");
                for(int k=0;k<z;k++){
                    int r= Integer.parseInt(stringTokenizer1.nextToken());
                    tomato[i][j][k]=r;
                    if(r==0){
                        b2=1;
                    }
                    if(r==1){
                        b3=1;
                    }
                    if(r==1){
                        queue.add(new G(i,j,k));
                        b[i][j][k]=true;
                    }
                }
            }
        }

        if(b2!=1&&b3==1){
            System.out.println(0);
            return;
        }
        bfs();

    }
    public static void bfs(){
        while(!queue.isEmpty()){
            G g=queue.poll();
            for(int i=0;i<6;i++){
                int xx=nx[i]+g.x;
                int yy=ny[i]+g.y;
                int zz=nz[i]+g.z;
                if(xx>=0&&xx<x&&yy>=0&&yy<y&&zz>=0&&zz<z){
                    if(tomato[xx][yy][zz]==0&&!b[xx][yy][zz]){
                        queue.add(new G(xx,yy,zz));
                        b[xx][yy][zz]=true;
                        count[xx][yy][zz]=count[g.x][g.y][g.z]+1;
                    }
                }
            }
        }
        int b1=0;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                for(int k=0;k<z;k++){
                    if(count[i][j][k]==0&&tomato[i][j][k]==0){
                        b1=1;
                    }
                }
            }
        }
        if(b1==1){
            System.out.println(-1);

        }else {


        int sum=0;
        for(int i=0;i<x;i++){
        for(int j=0;j<y;j++){
            for(int k=0;k<z;k++){
                sum=Math.max(count[i][j][k],sum);
            }
        }
        }
        System.out.println(sum);}
    }
    static class G{
        int x;
        int y;
        int z;

        public G(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
