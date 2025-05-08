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
        Book book1 = new Book("자바책", 12000, "자비스");
        
        
        // TODO: Electronics 객체 생성
        Electronics phone = new Electronics("갤럭시", 1000000, "삼성");
        
        
        // TODO: DiscountedBook 객체 생성
        DiscountedBook book2 = new DiscountedBook("쿠버네티스", 20000, "쿠바연구회", 0.2);
        
        
        // TODO: ShoppingCart 객체 생성
        ShoppingCart cart = new ShoppingCart();
        
        
        // TODO: 장바구니에 상품 추가하기
        cart.addBuyable(book1);
        cart.addBuyable(phone);
        cart.addBuyable(book2);

        
        
        // TODO: 장바구니 내용과 총액 출력하기
        cart.printShoppingCart();
        System.out.println("장바구니 총액 : " + cart.allPrice());
        
        
        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        //       - 모든 상품의 정보 출력하기
        Buyable[] buyables = {book1, phone, book2};

        for (Buyable buyable : buyables) {
            buyable.info();
            System.out.println();
        }
        
        
        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        for (Buyable buyable : buyables) {
            if(buyable instanceof DiscountedBook) {
                buyable.info();
                System.out.println();
            }
        }
        
    }
} 