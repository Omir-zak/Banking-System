package banking_system;

public class Account {
    protected int accountNum;
    protected int bal;

    protected Account(int accountNumber) {
        this.accountNum = accountNumber;
        this.bal = 0;
    }

    protected int getNum() {return accountNum;}

    protected int getBal() {return bal;}

    protected void setBal(int balance) {this.bal = balance;}
}
