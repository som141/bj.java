package cordforce.test.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MilyaandTwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int size= Integer.parseInt(br.readLine());
            int []a= new int[size];
            int []b= new int[size];
            String s1= br.readLine();
            StringTokenizer st= new StringTokenizer(s1," ");
            for(int j=0;j<size;j++){
                a[j]= Integer.parseInt(st.nextToken());
            }
            String s2= br.readLine();
            StringTokenizer st2= new StringTokenizer(s2," ");
            for(int j=0;j<size;j++){
                b[j]= Integer.parseInt(st2.nextToken());
            }
            System.out.println(solve(a,b));
        }
    }
    public static String solve(int []a,int[] b){
        int count=0;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                set.add(a[i]+b[j]);
            }
        }
        if(set.size()>=3){
            return "YES";
        }
        else{
            return "NO";
        }
    }
}
