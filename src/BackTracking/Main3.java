package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    static int num;
    static int costs;
    static int count;
    static int []array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        num = Integer.parseInt(st.nextToken());
        costs = Integer.parseInt(st.nextToken());
        array = new int[num+1];
        count = 0;
        String str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=1;i<=num;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        recusion(0,0);
        System.out.println((costs==0)?count-1:count);

    }
    static void recusion(int n,int cost){
        if(n==num){
            if(cost==costs){
                count++;
            }
            return;
        }
        recusion(n+1,cost+array[n+1]);
        recusion(n+1,cost);

    }
    static void printArray(){
        for(int i=1;i<=num;i++){
            System.out.println(array[i]);
        }
    }
}
