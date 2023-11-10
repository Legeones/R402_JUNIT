package TP;

public class BankAccount {
    private double balance;
    private double decouvert;

    public BankAccount() {
        this.balance = 0;
        this.decouvert = 0;
    }

    public BankAccount(double balance, double decouvert){
        this.balance = balance;
        this.decouvert = decouvert;
    }

    public void deposit(double amount) {
        System.out.println("Solde initiale de "+this.balance+":");
        balance += amount;
        System.out.println("Vous avez déposer "+amount+", votre solde est désormais à "+this.balance);
    }

    public void withdraw(double amount) {
        if(balance-amount < decouvert){
            throw new IllegalArgumentException("Le solde est insuffisant");
        }
        System.out.println("Solde initiale de "+this.balance+":");
        balance -= amount;
        System.out.println("Vous avez retirer "+amount+", votre solde est désormais à "+this.balance);
        return;
    }

    public void setDecouvert(double decouvert){
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public double checkBalance() {
        return balance;
    }
}

