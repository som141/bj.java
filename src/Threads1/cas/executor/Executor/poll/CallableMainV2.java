package Threads1.cas.executor.Executor.poll;

import java.util.Random;
import java.util.concurrent.*;

import static Threads1.cas.util.Sp.sleep;
import static Threads1.cas.util.logger.log;


public class CallableMainV2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("submit() call ");
        Future<Object> future = es.submit(new MyCallable());
        log("future returns,f future = "+future);

        log("future.get() [블로킹] 메서드 호출 시작 -> main Thread WAITING");
        Integer result = (Integer) future.get();
        log("future.get() [블로킹] 메서드 호출 완료 -> main Thread RUNNABLE");
        log("result: " + result);
        log("future 완료, future = "+future);
        es.close();
    }
    static class MyCallable implements Callable<Object> {
        @Override
        public Object call() throws Exception {
            log("Callable Start");
            sleep(2000);
            int value= new Random().nextInt(100);
            log("create value: "+value);
            log("Callable End");
            return value;
        }
    }
}
