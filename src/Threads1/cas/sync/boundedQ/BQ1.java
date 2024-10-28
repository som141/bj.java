package Threads1.cas.sync.boundedQ;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import static Threads1.cas.util.logger.log;

public class BQ1 implements BQ{
    private final Queue<String> queue=new ArrayDeque<String>();
    private int max;
    BQ1(int max){
        this.max=max;
    }
    @Override
    public synchronized void put(String s) {
        if(queue.size()==max){
            log("사이즈 꽉참 더 이상 안됨"+s);
            return;
        }
        queue.offer(s);
    }

    @Override
    public synchronized String take() {
        if(queue.isEmpty()){
            return null;
        }
        return queue.poll();
    }

    @Override
    public synchronized String toString() {
        return queue.toString();//컬렉션 애들은 이미 다 구현되어 있어서 이 지랄 할 필요 없음.
    }
}
