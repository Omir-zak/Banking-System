package banking_system;

public class ATM {
    private Bank bank;
    private int sessionAccNum = -1;

    public ATM() {}

    protected void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean loginToAccount(int acctNum) {
        try {
            bank.accessAcctInfo(acctNum);
            sessionAccNum = acctNum;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deposit(int amount) {
        if (sessionAccNum == -1) {
            return false;
        }
        try {
            bank.updateAcctBal(sessionAccNum, amount);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean withdraw(int amount) {
        if (sessionAccNum == -1) {
            return false;
        }
        try {
            bank.updateAcctBal(sessionAccNum, -amount);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public int getBalance() {
        if (sessionAccNum == -1) {
            return 0;
        }
        try {
            return bank.accessAcctInfo(sessionAccNum);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public void logout() {
        sessionAccNum = -1;
    }
}
