package Threads1.cas.sync.boundedQ;

import static Threads1.cas.util.logger.log;

public class ProducerTask implements Runnable {
    private BQ queue;
    public String request;
    public ProducerTask(BQ queue, String request) {
        this.queue = queue;
        this.request = request;
    }
    @Override
    public void run() {
        log("생산시도"+request+" -> " + queue);
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log("생산성공"+request+" -> " + queue);
    }
}
