class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}


class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }


    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Error: Not enough balance!");
        } else {
            balance -= amount;
            System.out.println("Withdraw successful. Remaining balance: " + balance);
        }
    }
}


public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000);

        try {
            account.withdraw(2000);  //ok
            account.withdraw(4000);  // Error
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Transaction completed.");
        }
    }
}