package Threads1.cas.Increment;

public class BasicInteger implements IncrementInter{
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
