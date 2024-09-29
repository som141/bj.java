package Threads1.cas.BankAccount;

public class WithdrawTask implements Runnable {
    private Bkl account;
    private int amount;
    public WithdrawTask(Bkl account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    @Override
    public void run() {
        account.withdraw(amount);
    }
}