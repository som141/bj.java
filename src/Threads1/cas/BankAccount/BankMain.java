package Threads1.cas.BankAccount;

import static Threads1.cas.util.Sp.sleep;
import static Threads1.cas.util.logger.log;

public class BankMain {
         public static void main(String[] args) throws InterruptedException{
        Bkl account = new Bkv1(1000);
        Thread t1 = new Thread(new WithdrawTask(account, 800), "t1");
        Thread t2 = new Thread(new WithdrawTask(account, 800), "t2");
        t1.start();
        t2.start();
        sleep(500);
        log("t1 state: " + t1.getState());

        log("t2 state: " + t2.getState());
        t1.join();
        t2.join();
        log("최종 잔액: " + account.getBalance());
    }
}
