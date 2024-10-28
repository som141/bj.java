package Threads1.cas.sync.boundedQ;

public interface BQ {
    void put(String s);
    String take();
}
