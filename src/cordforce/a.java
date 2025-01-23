package cordforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c= Integer.parseInt(br.readLine());
        for(int i=0;i<c;i++){
            int [] fibonacci=new int[3];
            String s=br.readLine();
            StringTokenizer st=new StringTokenizer(s);
            int a1=Integer.parseInt(st.nextToken());
            int a2=Integer.parseInt(st.nextToken());
            int a3=Integer.parseInt(st.nextToken());
            int a4=Integer.parseInt(st.nextToken());

            fibonacci[0]=a1+a2;
            fibonacci[1]=a3-a2;
            fibonacci[2]=a4-a3;
            int max=0;
            for(int j=0;j<3;j++) {
                max=solve(fibonacci[j],max,a1,a2,a3,a4);
            }
            System.out.println(max);
        }
    }

    private static int solve(int i, int max, int a1, int a2, int a3, int a4) {
        int current=0;
        if(i==a1+a2){
            current+=1;
        }
        if(i==a3-a2){
            current+=1;
        }
        if(i==a4-a3){
            current+=1;
        }
        return max(current,max);
    }
}
