package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * 인터페이스 구현과 다형성을 테스트하는 클래스입니다.
 */
public class ShopTest {
    public static void main(String[] args) {
        System.out.println("Lab 3: 인터페이스 활용하기 실습");
        
        // TODO: Book 객체 생성
        Book book1 = new Book("이방인", 10000, "카뮈");

        // TODO: Electronics 객체 생성
        Buyable product1 = new Electronics("갤럭시탭S9", 900000, "삼성");
        
        // TODO: DiscountedBook 객체 생성
        Buyable book2 = new DiscountedBook("해리포터", 9000, "롤링", 10);

        // TODO: ShoppingCart 객체 생성
        ShoppingCart myCart = new ShoppingCart();

        // TODO: 장바구니에 상품 추가하기
        myCart.addProduct(product1);
        myCart.addProduct(book1);
        myCart.addProduct(book2);

        
        // TODO: 장바구니 내용과 총액 출력하기
        myCart.printCartList();
        
        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        //       - 모든 상품의 정보 출력하기
        
        
        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        myCart.printDiscountedProduct();
    }
} 