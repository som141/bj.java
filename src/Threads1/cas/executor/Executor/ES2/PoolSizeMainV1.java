package Threads1.cas.executor.Executor.ES2;

import Threads1.cas.executor.Executor.poll.RunnableTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static Threads1.cas.executor.Executor.Utills.printState;

public class PoolSizeMainV1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue= new ArrayBlockingQueue<>(2);//2개짜리 블로킹 큐 생성
        ExecutorService es = new ThreadPoolExecutor(2,4,3000, TimeUnit.MILLISECONDS,workQueue);
        printState(es);

        es.execute(new RunnableTask("t1"));
        printState(es,"t1");
        es.execute(new RunnableTask("t2"));
        printState(es,"t2");
        es.execute(new RunnableTask("t3"));
        printState(es,"t3");
        es.execute(new RunnableTask("t4"));
        printState(es,"t4");
        es.execute(new RunnableTask("t5"));
        printState(es,"t5");
        es.execute(new RunnableTask("t6"));
        printState(es,"t6");
        es.execute(new RunnableTask("t7"));
        printState(es,"t7");
    }
}
