package outside;

import banking_system.ATM;
import banking_system.Bank;

public class Customer {
    private Bank bank;
    private ATM atm;
    private int accountNum = -1;
    
    public Customer(Bank bank, ATM atm) {
        this.bank = bank;
        this.atm = atm;
        this.accountNum = -1;
    }

    public int openAccount() {
        this.accountNum = bank.createAccount();
        return this.accountNum;
    }

    public boolean depositMoney(int amount) {
        if (this.accountNum == -1) {
            return false;
        }

        if (atm.loginToAccount(this.accountNum)) {
            if (atm.deposit(amount)) {
                atm.logout();
                return true;
            } else {
                atm.logout();
                return false;
            }
        }
        return false;
    }

    public boolean withdrawMoney(int amount) {
        if (this.accountNum == -1) {
            return false;
        }

        if (atm.loginToAccount(this.accountNum)) {
            if (atm.withdraw(amount)) {
                atm.logout();
                return true;
            } else {
                atm.logout();
                return false;
            }
        }
        return false;
    }

    public int checkBalance() {
        if (this.accountNum == -1) {
            return 0;
        }

        if (atm.loginToAccount(this.accountNum)) {
            int bal = atm.getBalance();
            atm.logout();
            return bal;
        }
        return 0;
    }
}

