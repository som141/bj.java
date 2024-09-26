package Threads1.cas.print;

import static Threads1.cas.util.logger.log;

public class print1 {
    public static int i;
    public static void main(String[] args) throws InterruptedException {
        log("main log");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("멀티 스레드 "+Thread.currentThread().getName()+"  "+Thread.currentThread().getState());
                i+=50;
            }
        };

        Thread thread1 = new Thread(runnable,"T1");
        Thread thread2 = new Thread(runnable,"T2");
        i=0;
        thread1.start();
        thread2.start();
        System.out.println(i);
        log("main log");
    }
}
