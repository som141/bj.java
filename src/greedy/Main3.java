package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3  {
    static int [][]w;
    static int d[];
    static boolean b[];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s= bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s," ");
        int num1 = Integer.parseInt(stringTokenizer.nextToken());
        int num2 = Integer.parseInt(stringTokenizer.nextToken());
        int num3= Integer.parseInt(stringTokenizer.nextToken());
        w= new int[num1+1][num1+1];
        d= new int[num1+1];
        b= new boolean[num1+1];
        for(int i=1;i<=num1;i++){
            for( int j=1;j<=num1;j++){
                w[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<num2;i++){
            String s1= bufferedReader.readLine();
            StringTokenizer stringTokenizer1 = new StringTokenizer(s1," ");
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            int n3= Integer.parseInt(stringTokenizer.nextToken());
            w[n1][n2]=n3;
            w[n2][n1]=n3;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=num1;i++){
            min=Integer.min(min,w[num3][i]);
        }


    }

}
