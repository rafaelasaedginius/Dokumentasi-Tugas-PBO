public class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setor(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void tarik(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}