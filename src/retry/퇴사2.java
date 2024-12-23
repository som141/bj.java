package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 퇴사2 {
    static int[]t;
    static int []p;
    static int []dp;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(br.readLine());
        t= new int[num+1];
        p= new int[num+1];
        dp= new int[num+1];

        for(int i=1;i<num+1;i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            t[i]= Integer.parseInt(st.nextToken());
            p[i]= Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<num+1;i++){
            dp[i] = Math.max(dp[i], dp[i-1]);
            if(i+t[i]<=num+1) {
                dp[i-1+t[i]] = Math.max(dp[i-1+t[i]], dp[i-1]+p[i]);
            }
        }
        System.out.println(dp[num]);
    }
}
