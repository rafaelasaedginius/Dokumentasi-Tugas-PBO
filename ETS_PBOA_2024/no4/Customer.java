public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, double initialBalance) {
        this.name = name;
        this.account = new BankAccount(initialBalance);
    }

    public double checkBalance() {
        return account.getBalance();
    }

    public void setorToAccount(double amount) {
        account.setor(amount);
        System.out.println("Setor berhasil. Saldo saat ini: Rp " + account.getBalance());
    }

    public void tarikFromAccount(double amount) {
        account.tarik(amount);
        System.out.println("Tarik berhasil. Saldo saat ini: Rp " + account.getBalance());
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("Asa", 1000000);

        System.out.println("Saldo awal: Rp " + customer1.checkBalance());
        customer1.setorToAccount(500000);
        customer1.tarikFromAccount(300000);
        System.out.println("Saldo akhir: Rp " + customer1.checkBalance());
    }
}