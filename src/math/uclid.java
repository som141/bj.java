package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class uclid {
    static int solve(int a,int b){

        int v=a%b;
        if(v==0){
            return b;
        }
        return solve(b,v);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        System.out.println(solve(a,b));
        System.out.println(a*b/solve(a,b));
    }
}
