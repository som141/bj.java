package Threads1.cas.sync;

public class s3 {
        static synchronized void pr(){
            System.out.println("pr");
        }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            pr();
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        t1.join();
    }

}
