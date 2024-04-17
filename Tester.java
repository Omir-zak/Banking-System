package outside;

import banking_system.ATM;
import banking_system.Bank;

public class Tester {
    public static void main(String[] args) {
        Bank bank = new Bank();

        ATM atm1 = new ATM();
        ATM atm2 = new ATM();
        bank.attachATM(atm1);
        bank.attachATM(atm2);

        Customer customer1 = new Customer(bank, atm1);
        Customer customer2 = new Customer(bank, atm1);
        Customer customer3 = new Customer(bank, atm2);

        int accNum1 = customer1.openAccount();
        int accNum2 = customer2.openAccount();
        int accNum3 = customer3.openAccount();

        System.out.println("Customer 1 num " + accNum1);
        System.out.println("Customer 2 num " + accNum2);
        System.out.println("Customer 3 num " + accNum3);

        System.out.println("Customer 3 balance " + customer3.checkBalance());
        System.out.println("Customer 3 depositing " + customer3.depositMoney(1000));
        System.out.println("Customer 3 balance " + customer3.checkBalance());

        System.out.println("Customer 1 balance " + customer1.checkBalance());
        System.out.println("Customer 1 depositing " + customer1.depositMoney(200));
        System.out.println("Customer 1 balance " + customer1.checkBalance());

        System.out.println("Customer 2 balance " + customer2.checkBalance());
        System.out.println("Customer 2 depositing " + customer2.depositMoney(-100));
        System.out.println("Customer 2 balance " + customer2.checkBalance());

        System.out.println("Customer 1 withdrawing " + customer1.withdrawMoney(400));
        System.out.println("Customer 2 depositing " + customer2.depositMoney(100));
        System.out.println("Customer 3 withdrawing " + customer3.withdrawMoney(-300));

        System.out.println("Customer 1 balance " + customer1.checkBalance());
        System.out.println("Customer 2 balance " + customer2.checkBalance());
        System.out.println("Customer 3 balance " + customer3.checkBalance());

        atm1.loginToAccount(5);
    }
}
