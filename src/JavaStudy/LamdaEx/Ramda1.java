package JavaStudy.LamdaEx;


import java.util.Arrays;
import java.util.Comparator;

public class Ramda1 {
    public static void main(String[] args) throws InterruptedException {
        String[] strings={"아러닐","fksjdf","ㅇㄹㄴㄹㅇ"};
        Comparator<? extends String> comparable = (f, s)->f.length()-s.length();
        Arrays.sort(strings,(f,s)->f.length()-s.length());//sort메서드 두번째 인수는 compareable이 구현된 뭔가를 넣어야하는데 여기서 람다로 구현해버림.
        for(int i=0;i<strings.length;i++){
            System.out.println(strings[i]);
        }
//        Runnable runnable =()-> {
//            System.out.println("Hello World");
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();
//        thread.join();
    }
}
