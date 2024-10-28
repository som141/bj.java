package Threads1.cas.sync.boundedQ;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static Threads1.cas.util.logger.log;

public class BQ4 implements BQ{
    private final Queue<String> queue=new ArrayDeque<String>();
    private int max;
    private final Lock lock=new ReentrantLock();
    private final Condition Condition1=lock.newCondition();
    private final Condition Condition2=lock.newCondition();
    BQ4(int max){
        this.max=max;
    }
    @Override
    public void put(String s) {
        lock.lock();
        try {
        if (queue.size() == max) {
            log("사이즈 꽉참 더 이상 안됨 wait()으로 키 반납하고 대기" + s);
            try {
                Condition1.await();
                log("생산자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(s);
        log("생산자 데이터 저장했음 conditon1(생산자 전용 대기장소) 호출 할게요! ");
        Condition2.signal();
    }finally{
            lock.unlock();
        }
    }

    @Override
    public String take() {
        lock.lock();
        try {
            if (queue.isEmpty()) {
                log("텅 비었음 더 이상 안됨 wait()으로 키 반납하고 대기");
                try {
                    Condition2.await();
                    log("소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String result = queue.poll();
            log("소비자 데이터 제거했음 conditon2(소비자 전용 대기장소) 호출 할게요! ");
            Condition1.signal();
            return result;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized String toString() {
        return queue.toString();//컬렉션 애들은 이미 다 구현되어 있어서 이 지랄 할 필요 없음.
    }
}
