package Threads1.cas.sync.boundedQ;

public interface BQ {
    void put(String s) throws InterruptedException;
    String take() throws InterruptedException;
}
