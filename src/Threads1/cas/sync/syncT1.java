package Threads1.cas.sync;

public class syncT1 {
    static class count{
        int count;
        synchronized void increment(){
            count++;
        }
        int getCount(){
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        count count1 = new count();
        Runnable t1 = new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    count1.increment();
                }
            }
        };
        Thread t2 = new Thread(t1);
        Thread t3 = new Thread(t2);
        t2.start();
        t3.start();
        t2.join();
        t3.join();
        System.out.println(count1.getCount());

    }
}
