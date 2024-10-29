package Threads1.cas.sync.boundedQ;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static Threads1.cas.util.logger.log;

public class BQ6 implements BQ{
    private BlockingQueue<String> queue;
    public BQ6(int max){
        queue= new ArrayBlockingQueue<>(max);
    }
    @Override
    public void put(String s) {
        try {
            queue.put(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String take() {
        try {return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return queue.toString();//컬렉션 애들은 이미 다 구현되어 있어서 이 지랄 할 필요 없음.
    }
}
