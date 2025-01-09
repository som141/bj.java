package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class playstation {
    static Queue<Character> q1 = new LinkedList<>();
    static Queue<Character> q2=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        String s= br.readLine();
        boolean flag=false;
        q1.add('P');
        q2.add('P');
        q1.add('S');
        q2.add('S');
        q1.add('4');
        q2.add('5');
        for(char c:s.toCharArray()){
            if(!flag){
                int count=0;
                for(int i=48;i<=57;i++){
                    if(Integer.valueOf(c)==i){
                        count++;
                    }
                }
                if(count==0){
                    System.out.print(c);
                }
            }else{
                System.out.print(c);
            }
            if(!q1.isEmpty()) {
                if (c == q1.peek()) {
                    q1.poll();
                    if (q1.isEmpty() && q2.isEmpty()) {
                        flag = true;
                    }
                }
            }
            if(!q2.isEmpty()){
            if(c==q2.peek()) {
                q2.poll();
                if (q2.isEmpty()&&q1.isEmpty()) {
                    flag = true;
                }
            }
            }

        }



        }





    }

