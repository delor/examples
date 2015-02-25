package example;

public class Account {
    private int balance;

    public Account(int initialBalance) {
        if (initialBalance < 0)
            throw new IllegalArgumentException("Initial balance has to be greater or equal to zero");

        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount < 1)
            throw new IllegalTransaction("The minimal amount to deposit is 1");
        if (Integer.MAX_VALUE - amount > balance)
            throw new IllegalTransaction("This deposit exceeds the maximum value that can be stored in account");

        balance = balance + amount;
    }

    public void withdraw(int amount) {
        if (amount < 1)
            throw new IllegalTransaction("The minimal amount to withdraw is 1");
        if (amount > balance)
            throw new InsufficientFunds();

        balance = balance - amount;
    }

    public int balance() {
        return balance;
    }

    @Override
    public String toString() {
        return "example.Account{" +
                "balance=" + balance +
                '}';
    }

    public class IllegalTransaction extends RuntimeException {
        public IllegalTransaction(String message) {
            super(message);
        }
    }

    public class InsufficientFunds extends IllegalTransaction {
        public InsufficientFunds() {
            super("Not enough funds in account");
        }
    }
}
