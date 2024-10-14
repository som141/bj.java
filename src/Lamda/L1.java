package Lamda;

public class L1 {
    public static void main(String[] args) {
        Runnable r =()-> {System.out.println("Hello World");
            System.out.println(Thread.currentThread().getName());};
        new Thread(r).start();
        new Thread(r).start();
    }
}
