package goldRandomDepense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);
        int n= Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());
        int []house=new int[n];
        for(int i=0;i<n;i++){
            house[i]=Integer.parseInt(br.readLine());
        }
        System.out.println(solve(house,c));
    }
    static boolean p2(int[] houses,int distance, int c){
        int count = 1;
        int lastRouter = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastRouter >= distance) {
                count++;
                lastRouter = houses[i];
                if (count >= c) {
                    return true;
                }
            }
        }
        return false;
    }
    static int solve(int[] house,int c){
        int low=1;
        int high=house.length-1;
        int result=0;
        Arrays.sort(house);
        while(low<=high){
            int mid=(low+high)/2;
            if(p2(house,mid,c)){
                result=mid;
                low=mid+1;
            }else {
                high = mid - 1;
            }

        }
        return result;
    }
}
