package chapter4.labs.lab2;

/**
 * Lab 2: 생성자 활용하기
 * 
 * Book 클래스 정의하기
 */
public class Book {
    // TODO: 제목, 저자, 가격, 출판연도를 저장할 수 있는 필드를 정의하세요.
    String title;
    String author;
    int price;
    int year;
    
    
    
    // TODO: 기본 생성자를 정의하세요.
    Book() {
        this("No Title");
    }

    
    
    
    // TODO: 제목만 인자로 받는 생성자를 정의하세요. (this() 사용)
    Book(String title) {
        this(title, "Various Artist", 25000, 2025);
    }
    
    
    
    // TODO: 제목과 저자를 인자로 받는 생성자를 정의하세요. (this() 사용)
    Book(String title, String author) {
        this(title, author, 25000, 2025);
    }
    
    
    
    // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 정의하세요. (this() 사용)
    Book(String title, String author, int price) {
        this(title, author, price, 2025);
    }
    
    
    
    // TODO: 모든 필드를 인자로 받는 생성자를 정의하세요.
    Book(String title, String author, int price, int year) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
    }
    
    
    
    // TODO: 책의 정보를 출력하는 메소드를 정의하세요.
    void explain() {
        System.out.println("제목 : " + title + ", 저자 : " + author);
        System.out.println("가격 : " + price + "원, 출판년도 : " + year + "년");
    }
    
    
} 