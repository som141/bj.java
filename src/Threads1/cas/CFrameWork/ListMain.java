package Threads1.cas.CFrameWork;

import static Threads1.cas.util.logger.log;

public class ListMain {
    public static void main(String[] args) throws InterruptedException {
        GList list = new GList();
        test(list);
    }
    private static void test(simpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());

        Runnable runnable1 =()-> {
            list.add("A");
            log("Thread-1: list.add(A)");
        };
        Runnable runnable2 =()-> {
            list.add("B");
            log("Thread-2: list.add(B)");
        };
        Thread t1= new Thread(runnable1);
        Thread t2= new Thread(runnable2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list);

    }
}
