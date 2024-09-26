package Threads1.cas.csa;

public class BasicInteger implements IncrementInteger {
    private int value;
    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
