package codeTest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static char[]result;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        result= bufferedReader.readLine().toCharArray();
        for(int i=0;i<num-1;i++){
            char[]cs= bufferedReader.readLine().toCharArray();
            int lenth=Integer.max(result.length,cs.length );
            for(int j=0;j<lenth;j++){
                if(result[j]!=cs[j]){
                    cs[j]='?';
                }
            }
            result=cs;
        }
        System.out.println(result);
    }

}
