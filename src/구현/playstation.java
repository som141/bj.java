package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class playstation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;

        for (Character c : s.toCharArray()) {
            if (c == 'P') {
                flag1 = true;
                continue;
            }
            if (c == 'S' && flag1) {
                flag2 = true;
                continue;
            } else {
                if(!flag2){
                flag1 = false;
                continue;
                }
            }

            if (flag1 && flag2 && c != '4') {
                flag3 = true;
                continue;
            }
            if (flag1 && flag2 && c != '5') {
                flag3 = true;
                continue;
            }

            if(Character.isDigit(c)&&flag3){
                System.out.println(c);
                continue;
            }

            if (!Character.isDigit(c)) {
                System.out.print(c);
            }
        }
    }
}
