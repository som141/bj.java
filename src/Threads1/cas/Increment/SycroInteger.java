package Threads1.cas.Increment;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SycroInteger implements IncrementInter{
    private int value;
    private final Lock lock=new ReentrantLock();
    @Override
    public void increment() {
        lock.lock();
            value++;
        lock.unlock();
    }

    @Override
    public int get() {
        return value;
    }
}
