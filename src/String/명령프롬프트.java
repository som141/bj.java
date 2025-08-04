package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 명령프롬프트 {
    static int num;
    static List<String> arr=new ArrayList<>();
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        for(int i = 0; i<num;i++){
            String s = br.readLine();
            arr.add(s);
        }
        for(int i = 0; i<num;i++){

        }
    }
}
