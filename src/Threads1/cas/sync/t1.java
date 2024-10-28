package Threads1.cas.sync;

import java.util.concurrent.locks.LockSupport;

import static Threads1.cas.util.logger.log;

public class t1 {
    public static void main(String[] args) throws InterruptedException {
        thread1 t1 = new thread1();
        Thread t2 = new Thread(t1);
        t2.start();
        t2.join(1000);
        log("park걸림");
        t2.interrupt();

    }
    static class thread1 implements Runnable {
        @Override
        public void run() {
            log("park 걸꺼임"+Thread.currentThread().getState());
            LockSupport.park();
            log("인터럽트"+Thread.currentThread().getState());
            System.out.println(Thread.interrupted());
        }
    }
}
