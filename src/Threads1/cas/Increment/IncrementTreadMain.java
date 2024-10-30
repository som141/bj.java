package Threads1.cas.Increment;

import java.util.ArrayList;
import java.util.List;

import static Threads1.cas.util.Sp.sleep;

public class IncrementTreadMain {
    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test(new MyAtomicInteger());
    }
    public static void test(IncrementInter incrementInter) throws InterruptedException {
        Runnable runnable =()-> {
            sleep(10);
            incrementInter.increment();
        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();

        }
        for(Thread t : threads)
        {
            t.join();//메인쓰레드로 하여금 모든 쓰레드 조인걸기!
        }
        int result= incrementInter.get();
        System.out.println(result);
    }
}
