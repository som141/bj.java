package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {
        long a,b,c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);
        a=Long.parseLong(st.nextToken());
        b=Long.parseLong(st.nextToken());
        c=Long.parseLong(st.nextToken());
        System.out.println(modelMerge(a,b,c));

    }
    static long modelMerge(long a,long b,long c) {
        if(b==0){
            return 1;
        }
        long half= modelMerge(a,b/2,c);
        if(b%2==0) {
            half = (half * half) % c;
        }else half = (a * (half * half % c) % c);
        return half;
    }
}
