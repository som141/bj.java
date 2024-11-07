package Threads1.cas.executor.Executor.ES2;

import Threads1.cas.executor.Executor.poll.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static Threads1.cas.executor.Executor.Utills.printState;
import static Threads1.cas.util.Sp.sleep;
import static Threads1.cas.util.logger.log;

public class ExecutorShutdownMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute((new RunnableTask("a")));
        es.execute((new RunnableTask("b")));
        es.execute((new RunnableTask("c")));
        es.execute((new RunnableTask("log task",100000)));
        printState(es);
        log("==shutdown 실행==");
        shutdownAndAwaitTermination(es);
        log("shutdown 완료");
        sleep(1000);
        printState(es);
    }
    static void shutdownAndAwaitTermination(ExecutorService es) {
        es.shutdown();
        try {
            log("서비스 정상 종료 시도");
            if(!es.awaitTermination(10, TimeUnit.SECONDS)){
            log("서비스 정상 종료 실패 ->강제 종료 시도");
            es.shutdownNow();}
        }catch (InterruptedException e) {
            es.shutdownNow();
        }
    }
}
