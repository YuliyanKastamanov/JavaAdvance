package L06_DefiningClasses.Labs.P03_BankAccount;

public class BankAccount {




    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int bankAccountCount = 0;


    public BankAccount() {
        bankAccountCount++;
        this.id = bankAccountCount;
        this.balance = 0;

    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void deposit(double money){
        this.balance += money;
    }

    public double  getInterest (int years){
        return years * BankAccount.interestRate * this.balance;
    }
}
