package bitM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int array[];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        for(int i=0; i<num;i++){
            array=new int[(1<<11)-1];
            String s= bufferedReader.readLine();
            for(int j=0;j<s.length();j++){
                array[1<<(Character.getNumericValue(s.charAt(j))+1)]=1;
            }
            int sum=0;
            for (int j=0;j<(1<<11)-1;j++){
                sum+=array[j];
            }
            System.out.println(sum);

        }
    }
}
