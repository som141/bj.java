package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int [] w;
    static int [] x;
    static int sum;
    static int num1;
    static int num2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer streamTokenizer = new StringTokenizer(s," ");
        num1= Integer.parseInt(streamTokenizer.nextToken());
        num2= Integer.parseInt(streamTokenizer.nextToken());
        w = new int[num1+1];
        x = new int[num1+1];
        String s1= br.readLine();
        StringTokenizer streamTokenizer1 = new StringTokenizer(s1," ");
        int sum1=0;
        for(int i=1;i<=num1;i++){
            w[i] = Integer.parseInt(streamTokenizer1.nextToken());
            sum1+=w[i];
            x[i] = sum1;
        }

        for(int i=1;i<=num1;i++){
            for(int j=i;j<=num1;j++){
                int r=0;
                r=x[j]-x[i-1];
                if(r%num2==0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
