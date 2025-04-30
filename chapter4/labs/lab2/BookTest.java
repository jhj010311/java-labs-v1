package chapter4.labs.lab2;

/**
 * Lab 2: 생성자 활용하기
 * 
 * Book 클래스를 테스트하는 메인 클래스
 */
public class BookTest {
    public static void main(String[] args) {
        System.out.println("Book 클래스 테스트를 시작합니다.");
        
        // TODO: 기본 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book noTitle = new Book();
        noTitle.explain();
        System.out.println();
        
        
        
        // TODO: 제목만 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book yesTitle = new Book("Yes I have title");
        yesTitle.explain();
        System.out.println();
        
        
        
        // TODO: 제목과 저자를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book javaBook = new Book("Java Book", "SeSac");
        javaBook.explain();
        System.out.println();
        
        
        
        // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book cheapBook = new Book("1000원 유머책", "Humor", 1000);
        cheapBook.explain();
        System.out.println();
        
        
        
        // TODO: 모든 필드를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book awsBook = new Book("AWS MSA 과정", "SeSac", 12000, 2024);
        awsBook.explain();
        System.out.println();
        
        
        
        // TODO: 객체를 생성한 후 필드 값을 변경하고 정보를 출력하세요.
        Book noTitle2 = new Book();
        noTitle2.explain();

        System.out.println("값 수정");
        noTitle2.price = 10000;
        noTitle2.explain();
        
        
    }
} 