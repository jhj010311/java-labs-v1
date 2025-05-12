package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * Book 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현합니다.
 */
public class Book implements Buyable {
    // TODO: 책의 속성 정의 (예: 제목, 가격, 저자)
    private String title;
    private double price;
    private String author;
    
    // TODO: 생성자 정의
    public Book(String title, double price, String author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    // TODO: Buyable 인터페이스의 메소드 구현

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getProductName() {
        return this.title;
    }


    // TODO: 책만의 고유한 메소드 추가
    
} 