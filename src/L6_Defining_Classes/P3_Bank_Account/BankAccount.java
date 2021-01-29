package L6_Defining_Classes.P3_Bank_Account;

public class BankAccount {
    private final static double DEFALUT_INTEREST = 0.02;
    private static double interesetRate = DEFALUT_INTEREST;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    BankAccount() {
        this.id = bankAccountCount++;
    }

    public int getId() {
        return id;
    }

    public void setInterest(double interest) {
        BankAccount.interesetRate = interest;
    }

    void deposit (double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return BankAccount.interesetRate * years * this.balance;
    }
}
