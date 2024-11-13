package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1 {
    public static void main(String[] args) throws IOException {
        String s;
        String patten;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        patten = br.readLine();
        int [] fp =failFuntion(patten);
    }

    private static int[] failFuntion(String patten) {
        int []fp=new int[patten.length()];

    }
}
