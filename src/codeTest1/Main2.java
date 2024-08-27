package codeTest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    int top;
    int stack[];
    public Main2() {
        top=-1;
        stack= new int[10000];
    }

    int isEmpty(){
        if(top==-1){
            return 1;
        }
        else{
            return 0;
        }
    }

    void push(int index ){
        if(top>=9999){
            System.out.println("스텍이 다 찼음..");
        }
        else{
            top++;
            stack[top]=index;
        }
    }
    int peek(){
        if(isEmpty()==1){
            return -1;
        }
        int p1=stack[top];
        return p1;
    }
    int pop(){
        int p2=peek();
        if(p2!=-1){
            top--;
        }
        return p2;
    }
    int size(){
        return top+1;
    }


    public static void main(String[] args) throws IOException {
        Main2 Main= new Main2();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<num;i++){
            String st= bufferedReader.readLine();
            StringTokenizer stringTokenizer=new StringTokenizer(st," ");
            String st1 = stringTokenizer.nextToken();
            if(st1.equals("push")){
                int index= Integer.parseInt(stringTokenizer.nextToken());
                Main.push(index);
            }
            else if(st1.equals("pop")){
                System.out.println(Main.pop());
            } else if (st1.equals("top")) {
                System.out.println(Main.peek());
                
            } else if (st1.equals("size")) {
                System.out.println(Main.size());
                
            } else if (st1.equals("empty")) {
                System.out.println(Main.isEmpty());
            }


        }
    }
}
