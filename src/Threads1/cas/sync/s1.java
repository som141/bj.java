package Threads1.cas.sync;

import java.util.concurrent.locks.LockSupport;

import static Threads1.cas.util.Sp.sleep;
import static Threads1.cas.util.logger.log;

public class s1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTask(), "Thread-1");
        thread1.start();
        // 잠시 대기하여 Thread-1이 park 상태에 빠질 시간을 준다.
        sleep(100);
        log("Thread-1 state: " + thread1.getState());
        log("main -> unpark(Thread-1)");
//        LockSupport.unpark(thread1); // 1. unpark 사용
        thread1.interrupt();  // 2. interrupt() 사용
        }
    static class ParkTask implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().interrupted());
            log("인터럽트 상태: " + Thread.currentThread().interrupted());

        }
    }
}