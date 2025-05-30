package chapter6.labs.lab3;

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

        if(accounts.containsKey(accountNumber)){
            throw new IllegalArgumentException("이미 존재하는 계좌번호입니다");
        } else if (initialBalance < 0) {
            throw new IllegalArgumentException("초기 잔액은 0 이상이어야 합니다");
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

        if(!accounts.containsKey(accountNumber)){
            throw new InvalidAccountException("존재하지 않는 계좌입니다", accountNumber);
        }
        
        return accounts.get(accountNumber); // 학생이 구현해야 하는 부분
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
        
        // 참고: 이 메소드에서 발생한 예외는 호출한 곳으로 전파됩니다.

//        if(amount <= 0){
//            throw new IllegalArgumentException("이체 금액은 1 이상이어야 합니다");
//        } else {
//            getAccount(fromAccountNumber).withdraw(amount);
//            getAccount(toAccountNumber).deposit(amount);
//            System.out.println(amount + " 이체 성공하였습니다");
//        }
//
        // 위의 경우, 입금받을 계좌가 유효하지 않아도 출금이 발생하기 때문에 문제의 소지가 있음
        // rollback할 방안을 마련하거나, 입금계좌를 미리 검증하는 것이 좋음


        BankAccount fromAccount = getAccount(fromAccountNumber);
        BankAccount toAccount = getAccount(toAccountNumber);

        if(amount <= 0){
            throw new IllegalArgumentException("이체 금액은 1 이상이어야 합니다");
        } else {
            getAccount(fromAccountNumber).withdraw(amount);
            getAccount(toAccountNumber).deposit(amount);
        }
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
} 