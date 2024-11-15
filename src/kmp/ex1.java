package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ex1 {
    public static void main(String[] args) throws IOException {
        String s;
        String patten;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        patten = br.readLine();
        List<Integer> queue = kmpSerch(s,patten);
        for(int i:queue){
            System.out.print(i+1+ " ");
        }

    }
    public static List kmpSerch(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int [] fp=failFuntion(p);
        int j=0;
        for(int i=0;i<s.length();i++) {
            while(j>0&&s.charAt(i)!=p.charAt(j)) {
                j=fp[j-1];
            }
            if(s.charAt(i)==p.charAt(j)) {
                j++;
            }
            if(j==p.length()) {
                list.add(i-j+1);
                j=fp[j-1];

            }

        }
        System.out.println(list.size());
        return list;
    }

    private static int[] failFuntion(String patten) {
        int []fp=new int[patten.length()];
        int j=0;
        for(int i=1;i<patten.length();i++) {
            while(j>0&& patten.charAt(i)!=patten.charAt(j)) {
                j=fp[j-1];
            }
            if(patten.charAt(i)==patten.charAt(j)) {
                j++;
            }
            fp[i]=j;
        }

        return fp;
    }
}
