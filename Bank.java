package banking_system;

import java.util.ArrayList;

public class Bank {
    private ArrayList<ATM> atms;
    private ArrayList<Account> accounts;
    private int accountNum = 0;

    public Bank() {
        accounts = new ArrayList<>();
        atms = new ArrayList<>();
        accountNum = 1;
    }
    
    public int createAccount() {
        accountNum++;
        Account newAcc= new Account(accountNum);
        accounts.add(newAcc);
        return newAcc.getNum();
    }

    public void attachATM(ATM atm) {
        atm.setBank(this);
        this.atms.add(atm);
    }

    protected int accessAcctInfo(int acctNum) throws Exception {
        for (Account acc : accounts) {
            if (acc.getNum() == acctNum) {
                return acc.getBal();
            }
        }
        throw new Exception("No corresponding account number is found.");
    }

    protected void updateAcctBal(int acctNum, int diff) throws Exception {
        for (Account acc : accounts) {
            if (acc.getNum() == acctNum) {
                if (acc.getBal() + diff < 0) {
                    throw new Exception("Not enough balance.");
                }
                acc.setBal(acc.getBal() + diff);
                return;
            }
        }
        throw new Exception("No corresponding account number is found.");
    }
}
