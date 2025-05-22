import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new BankAccount("123456789", 123456));
        accounts.add(new BankAccount("1234567890", 1234567));

        BankAccount myAccount = new BankAccount("159753456852", 5000.0d);
        myAccount.withdraw(500.0d);
        myAccount.deposit(1000.0d);

        System.out.println("계좌 번호 : "+myAccount.getMaskedAccountNumber());
        System.out.println("현재 계좌 잔액 : "+myAccount.getBalance());
    }
}
