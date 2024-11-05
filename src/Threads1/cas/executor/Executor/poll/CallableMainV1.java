package Threads1.cas.executor.Executor.poll;

import java.util.Random;
import java.util.concurrent.*;

import static Threads1.cas.util.Sp.sleep;;
import static Threads1.cas.util.logger.log;

public class CallableMainV1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);//new ThreadPoolExecutor()이거를 1개의 쓰레드만 생성하는 메서드
        Future<Object> future = es.submit(new MyCallable());
        Integer result = (Integer) future.get();
        log("result: " + result);
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
