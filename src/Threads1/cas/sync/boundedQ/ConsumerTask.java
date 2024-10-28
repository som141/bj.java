package Threads1.cas.sync.boundedQ;

import static Threads1.cas.util.logger.log;

public class ConsumerTask implements Runnable {
    private BQ queue;
    public ConsumerTask(BQ queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        log("소비 시도 : ? <-- "+queue);
        String data= queue.take();
        log("소비 완료: "+data+"<-- "+queue);
    }
}
