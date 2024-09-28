package Threads1.cas.print;

import static Threads1.cas.util.Sp.sleep;
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
                sleep(10000);

            }
        };

        Thread thread1 = new Thread(runnable,"T1");
        i=0;
        thread1.start();
        sleep(5000);
        thread1.interrupt();
        System.out.println(i);
        log("main log");
    }
}
