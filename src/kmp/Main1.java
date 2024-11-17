package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) throws IOException {
        String s;
        String patten;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        patten = br.readLine();
        List<Integer> queue = kmpSerch(s,patten);
        System.out.println(queue.size());
        for(int i:queue){
            System.out.print(i+1+ " ");
        }

    }
    public static List<Integer>kmpSerch(String s, String patten){
        List<Integer> result = new ArrayList<>();
        int []ff=failFuction(patten);
        int j=0;
        for(int i=0;i<s.length();i++){
            while(j>0&&s.charAt(i)!=patten.charAt(j)){
                j=ff[j-1];
            }
            if(s.charAt(i)==patten.charAt(j)){
                j++;
            }
            if(j==patten.length()){
                result.add(i-j+1);
                j=ff[j-1];
            }
        }
        return result;
    }
    public static int [] failFuction(String patten){
        int []ff=new int[patten.length()];
        int j=0;
        for(int i=1;i<patten.length();i++){
            while(j>0&&patten.charAt(i)!=patten.charAt(j)){
                j=ff[j-1];
            }
            if(patten.charAt(i)==patten.charAt(j)){
                j++;
            }
            ff[i]=j;
        }
        return ff;
    }
}
