package greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class floyd {
    static int INF=999999999;
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1= Integer.parseInt(bufferedReader.readLine());
        int num2= Integer.parseInt(bufferedReader.readLine());
        dp= new int[num1+1][num1+1];
        for(int i=1;i<=num1;i++){
            for(int j=1;j<=num1;j++){
                dp[i][j]=INF;
            }
        }
        for(int i=1;i<=num2;i++){
            String s1= bufferedReader.readLine();
            StringTokenizer stringTokenizer1= new StringTokenizer(s1," ");
            int n1= Integer.parseInt(stringTokenizer1.nextToken());
            int n2= Integer.parseInt(stringTokenizer1.nextToken());
            int n3= Integer.parseInt(stringTokenizer1.nextToken());
            dp[n1][n2]=Integer.min(dp[n1][n2],n3);
        }
        for(int i=1;i<=num1;i++){
            dp[i][i]=0;
        }
        for(int i=1;i<=num1;i++){
            for(int j=1;j<=num1;j++){
                for(int k=1;k<=num1;k++){
                    if(dp[j][i]!=INF&&dp[i][k]!=INF) {
                        dp[j][k] = Integer.min(dp[j][k], dp[j][i] + dp[i][k]);
                    }
                }
            }
        }
        for(int i=1;i<=num1;i++){
            for(int j=1;j<=num1;j++){
                if(dp[i][j]==INF){
                    System.out.print(0+" ");
                }
                else {
                    System.out.print(dp[i][j]+" ");
                }
            }
            System.out.println();
        }

    }
}
