package TP;

import java.util.ArrayList;
import java.util.HashMap;

public class BankAccountManager {
    private HashMap<Integer, BankAccount> bankAccounts;

    public BankAccountManager() {
        this.bankAccounts = new HashMap<>();
    }

    public void create(int num){
        bankAccounts.put(num, new BankAccount());
    }

    public void deposit(int accountId, double amount) {
        bankAccounts.get(accountId).deposit(amount);
    }

    public void withdraw(int accountId, double amount) {
        bankAccounts.get(accountId).withdraw(amount);
    }

    public double getBalance(int accountId) {
        return bankAccounts.get(accountId).checkBalance();
    }

    public double getDecouvert(int accountId){
        return bankAccounts.get(accountId).getDecouvert();
    }

    public void ajoutDecouvert(int accountId, double d){
        bankAccounts.get(accountId).setDecouvert(d);
    }
}
