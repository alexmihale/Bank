import bank.Bank;
import bank.BankAccount;
import bank.Currency;

public class Main {
    public static void main(String[] args) {
        BankAccount Radu = new BankAccount("Radu George", Currency.USD, "5468050458400842");
        BankAccount George = new BankAccount("George Mihai", Currency.RON,"5468451458400842");
        BankAccount Mihai = new BankAccount("Mihai Radu", Currency.EUR,"5468452458400842");
        BankAccount Jin = new BankAccount("Jin Yoh", Currency.YEN,"546851448400842");

        Bank.ING.registerBankAccount(Radu);
        Bank.ING.registerBankAccount(George);
        Bank.ING.registerBankAccount(Mihai);
        Bank.ING.registerBankAccount(Jin);

        Radu.depositMoney(40);
        George.depositMoney(200, Currency.EUR);
        Mihai.depositMoney(300, Currency.YEN);
        Jin.depositMoney(1000, Currency.USD);

        System.out.println(Radu.toString());
        System.out.println(George.toString());
        System.out.println(Mihai.toString());
        System.out.println(Jin.toString());

        Radu.withdrawMoney(500);
        Radu.withdrawMoney(2,Currency.USD);
        Radu.withdrawMoney(20, Currency.EUR);

        George.withdrawMoney(20,Currency.RON);
        Jin.withdrawMoney(912309312,Currency.YEN);
        Jin.withdrawMoney(3387,Currency.YEN);

        System.out.println(Radu.toString());
        System.out.println(George.toString());
        System.out.println(Mihai.toString());
        System.out.println(Jin.toString());

        System.out.println(Radu.getSold());
        System.out.println(Jin.getCurrency());

        System.out.println(Radu.verifyCreditCard("5468050458400842"));
        System.out.println(Mihai.verifyCreditCard("5468452458400842"));
        System.out.println(George.verifyCreditCard("5468451458400842"));
        System.out.println(Jin.verifyCreditCard("546851448400842"));
        System.out.println(Bank.ING.getNumberOfTotalAccounts());
        Bank.ING.deleteBankAccount(Jin);
        System.out.println(Jin.toString());
        System.out.println(Bank.ING.getNumberOfTotalAccounts());
    }
}
