package chapter6.labs.lab3solved;

import java.util.HashMap;
import java.util.Map;

/**
 * 은행 시스템 클래스
 * 
 * 여러 계좌를 관리하고 계좌 간 이체 기능을 제공하는 클래스입니다.
 */
public class BankingSystem {
    private Map<String, BankAccount> accounts;
    
    /**
     * 생성자
     */
    public BankingSystem() {
        this.accounts = new HashMap<>();
    }
    
    /**
     * 계좌 생성 메소드
     * @param accountNumber 계좌번호
     * @param ownerName 예금주 이름
     * @param initialBalance 초기 잔액
     * @throws IllegalArgumentException 계좌번호가 이미 존재하거나 초기 잔액이 0 미만인 경우
     */
    public void createAccount(String accountNumber, String ownerName, double initialBalance) 
            throws IllegalArgumentException {
        // TODO: 계좌번호가 이미 존재하는 경우 IllegalArgumentException을 발생시키세요.
        // TODO: 초기 잔액이 0 미만인 경우 IllegalArgumentException을 발생시키세요.
        // TODO: 새 계좌를 생성하고 계좌 목록에 추가하세요.

        if (accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("계좌번호가 이미 존재합니다.");
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException("초기 잔액이 0 미만입니다.");
        }

        accounts.put(accountNumber, new BankAccount(accountNumber, ownerName, initialBalance));

    }
    
    /**
     * 계좌 조회 메소드
     * @param accountNumber 조회할 계좌번호
     * @return 계좌 객체
     * @throws InvalidAccountException 계좌번호가 존재하지 않는 경우
     */
    public BankAccount getAccount(String accountNumber) throws InvalidAccountException {
        // TODO: 계좌번호가 존재하지 않는 경우 InvalidAccountException을 발생시키세요.
        // TODO: 계좌가 존재하면 해당 계좌 객체를 반환하세요.
        BankAccount bankAccount = accounts.get(accountNumber);
        if (bankAccount == null) throw new InvalidAccountException("계좌번호가 존재하지 않아요 : ", accountNumber);

        return bankAccount;
    }
    
    /**
     * 계좌 이체 메소드
     * @param fromAccountNumber 출금 계좌번호
     * @param toAccountNumber 입금 계좌번호
     * @param amount 이체 금액
     * @throws InvalidAccountException 계좌번호가 유효하지 않은 경우
     * @throws InsufficientBalanceException 잔액이 부족한 경우
     * @throws IllegalArgumentException 이체 금액이 0 이하인 경우
     */
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) 
            throws InvalidAccountException, InsufficientBalanceException, IllegalArgumentException {
        // TODO: 메소드를 구현하세요. 다음 단계를 따르세요:
        // 1. 출금 계좌와 입금 계좌가 유효한지 확인하세요. (getAccount 메소드 활용)
        // 2. 이체 금액이 0 이하인 경우 IllegalArgumentException을 발생시키세요.
        // 3. 출금 계좌에서 금액을 인출하세요. (withdraw 메소드 활용)
        // 4. 입금 계좌에 금액을 입금하세요. (deposit 메소드 활용)
        // 5. 이체 성공 메시지를 출력하세요.

        BankAccount fromAccount = getAccount(fromAccountNumber);
        BankAccount toAccount = getAccount(toAccountNumber);

        if (amount <= 0) {
            throw new IllegalArgumentException("이체금액이 0 이하 입니다.");
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        System.out.println(amount + "원 이체가 성공하였습니다." );


        // 참고: 이 메소드에서 발생한 예외는 호출한 곳으로 전파됩니다.
    }
    
    /**
     * 모든 계좌 정보 출력 메소드
     */
    public void displayAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        if (accounts.isEmpty()) {
            System.out.println("등록된 계좌가 없습니다.");
            return;
        }
        
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }

    public void deposit(String accountNumber, int amount) throws InvalidAccountException {
        BankAccount account = getAccount(accountNumber);

        account.deposit(amount);

        System.out.println(account.getAccountNumber() + "계좌로 입금 완료 되었습니다 : " + amount + "원" );
    }

    public void withdraw(String accountNumber, int amount) throws InvalidAccountException, InsufficientBalanceException {
        BankAccount account = getAccount(accountNumber);

        account.withdraw(amount);

        System.out.println(account.getAccountNumber() + "계좌에서 출금 완료 되었습니다 : " + amount + "원" );
    }
}