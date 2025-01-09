package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그런사람은없었습니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int num=Integer.parseInt(st.nextToken());
        people []arrays=new people[num+1];
        int caseNum=Integer.parseInt(st.nextToken());
        int maxCount= Integer.parseInt(br.readLine());
        for(int i=1;i<=num;i++){
            arrays[i]=new people();
        }
        for(int i=0;i<caseNum;i++){
            String s1=br.readLine();
            StringTokenizer st1 = new StringTokenizer(s1);
            int a=Integer.parseInt(st1.nextToken());
            int b=Integer.parseInt(st1.nextToken());


            if(b==0&&arrays[a].count<maxCount){

                arrays[a].formflag=true;
                arrays[a].flag=false;
                for(int j=1;j<=num;j++){
                    if(arrays[j].flag==true&&j!=a&&arrays[j].formflag==false){
                        arrays[j].count++;
                    }
                }

            }
            if(b==1&&arrays[a].formflag==false){
                arrays[a].flag=true;

            }

        }
        int result=0;
        for(int i=1;i<=num;i++){
            if(arrays[i].formflag==false&&arrays[i].count>=maxCount){
                System.out.println(i);
                result++;
            }
        }
        if(result==0){
            System.out.println(-1);
        }
    }
    static class people{
        int count;
        boolean flag;
        boolean formflag;
        public people() {
            count = 0;
            flag = false;
            formflag = false;
        }

    }
}
