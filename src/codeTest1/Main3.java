
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    public int sort[];



    public Main3(int lenth) {
        this.sort = new int[lenth];
    }
    public int bSeach(int index,int[]array){
        int top=array.length-1;
        int bottom=0;

        while(bottom<=top){
            int mid= (top+bottom)/2;
            if(index>array[mid]){
                bottom=mid+1;
            } else if (index<array[mid]) {
                top=mid-1;
            }else {
                return 1;
            }

        }return 0;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(bufferedReader.readLine());
        Main3 main3= new Main3(num);
        String st= bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(st," ");
        for(int i=0;i<num;i++){
            main3.sort[i]= Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(main3.sort);

        int num2= Integer.parseInt(bufferedReader.readLine());
        String st2= bufferedReader.readLine();
        StringTokenizer stringTokenizer2= new StringTokenizer(st2," ");
        for(int i=0;i<num2;i++){
            int result= Integer.parseInt(stringTokenizer2.nextToken());
            System.out.println(main3.bSeach(result,main3.sort));
        }

    }
}
