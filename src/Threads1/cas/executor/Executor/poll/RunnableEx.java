package Threads1.cas.executor.Executor.poll;

import java.util.Random;

import static Threads1.cas.util.Sp.sleep;
import static Threads1.cas.util.logger.log;

public class RunnableEx {
    public static void main(String[] args) throws InterruptedException {
        myRunnable runnable = new myRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        int result = runnable.value;
        log("result: " + result);
    }
    static class myRunnable implements Runnable {
    int value;
        @Override
        public void run() {//runnable 단점이 반환값이 없다, 예외를 던질 수 없다.
            //runnable run메서드가 예외를 안던졌으니 그의 구현체도 못 던짐(런타임 에러는 던지기 가능).
            log("Runnble Start");
            sleep(2000);
            value= new Random().nextInt(100);
            log("crate value: "+value);
            log("Runnble End");

        }
    }
}
