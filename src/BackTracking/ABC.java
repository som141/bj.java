package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABC {
    static int n1;
    static int n2;
    static int result;
    static char[][] arrays;
    static List<Character> list;
    static int[]nx={1,-1,0,0};
    static int[]ny={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1= br.readLine();
        StringTokenizer st = new StringTokenizer(s1);
         n1=Integer.parseInt(st.nextToken());
         n2=Integer.parseInt(st.nextToken());
        arrays=new char[n1][n2];
        list=new ArrayList<>();
        for(int i=0;i<n1;i++){
            String s2=br.readLine();
            for(int j=0;j<n2;j++){
                arrays[i][j]=s2.charAt(j);
            }
        }

        solve(1,0,0);
        System.out.println(result);
    }

    private static void solve(int n,int x, int y) {
        if(n>result){
            result=n;
        }
        list.add(arrays[x][y]);
        for(int i=0;i<4;i++){
            int nextX=nx[i]+x;
            int nextY=ny[i]+y;
            if(nextX>=0&&nextY>=0&&nextX<n1&&nextY<n2&&promising(nextX,nextY)){
                solve(n+1,nextX,nextY);
                list.remove(list.size()-1);
            }

        }
    }

    private static boolean promising(int nextX, int nextY) {
        char c=arrays[nextX][nextY];
        if(list.contains(c)){
            return false;
        }


        return true;
    }
}
