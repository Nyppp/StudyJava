public class BankAccount {
    //멤버 변수 > private으로 데이터 은닉(캡슐화)
    private double balance;
    private String accountNumber;

    //생성자 + 멤버 변수를 세팅할 수 있도록 매개변수 지정
    public BankAccount(String accountNumber, double initialDeposit){
        this.accountNumber = accountNumber;
        if(initialDeposit > 0){
            this.balance = initialDeposit;
        }
    }

    //멤버 변수를 반환하는 함수 (직접 접근은 불가)
    //만약 멤버변수가 참조형 타입인 경우, 직접 리턴하지 않고 객체를 복사해서 반환해야 함 (참조타입 리턴은 객체 접근 가능 > 캡슐화X)
    public double getBalance(){
        return balance;
    }

    public String getMaskedAccountNumber() {
        int len = accountNumber.length();
        return "*".repeat(len - 4) + accountNumber.substring(len-4);
    }

    
    //변수 값 설정 > setter 함수를 통해 사용
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    public void withdraw(double amount){
        double fee = 0.5;
        if(amount > 0 && balance >= amount+fee){
            balance -= (amount + fee);
        }
    }


}
