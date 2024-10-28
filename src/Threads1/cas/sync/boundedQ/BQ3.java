package Threads1.cas.sync.boundedQ;

import java.util.ArrayDeque;
import java.util.Queue;

import static Threads1.cas.util.logger.log;

public class BQ3 implements BQ{
    private final Queue<String> queue=new ArrayDeque<String>();
    private int max;
    BQ3(int max){
        this.max=max;
    }
    @Override
    public synchronized void put(String s) {
        if(queue.size()==max){
            log("사이즈 꽉참 더 이상 안됨 wait()으로 키 반납하고 대기"+s);
            try {
                wait();
                log("생산자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(s);
        log("생산자 데이터 저장했음 notify 호출 할게요! ");
        notify();
    }

    @Override
    public synchronized String take() {
        if(queue.isEmpty()){
            log("텅 비었음 더 이상 안됨 wait()으로 키 반납하고 대기");
            try {
                wait();
                log("소비자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String result=queue.poll();
        log("소비자 데이터 제거했음 notify 호출 할게요! ");
        notify();
        return result;
    }

    @Override
    public synchronized String toString() {
        return queue.toString();//컬렉션 애들은 이미 다 구현되어 있어서 이 지랄 할 필요 없음.
    }
}
