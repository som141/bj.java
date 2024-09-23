package cas;

import java.util.ArrayList;
import java.util.List;

public class IncrementThreadMain {
    public static final int THREAD_COUNT = 1000;
    public static void main(String[] args) {}
    private static void test(IncrementInteger incrementInteger){
        new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                incrementInteger.increment();
            }
        };
        List<Thread> threads = new ArrayList<>();

    }
}
