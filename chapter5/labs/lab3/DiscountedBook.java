package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * DiscountedBook 클래스를 정의하세요.
 * 이 클래스는 Book 클래스를 상속받고 Discountable 인터페이스를 구현합니다.
 */
public class DiscountedBook extends Book implements Discountable {
    // TODO: 할인 관련 속성 추가 (예: 할인율)
    double discount;
    
    
    // TODO: 생성자 정의
    DiscountedBook(String title, int price, String writer, double discount) {
        super(title, price, writer);
        this.discount = discount;
    }
    
    
    // TODO: Discountable 인터페이스의 메소드 구현

    @Override
    public double discount() {
        return discount * 100;
    }

    @Override
    public int applyDiscount() {
        return (int)(price * (1 - discount));
    }

    @Override
    public void discountInfo() {
        Discountable.super.discountInfo();
        System.out.println("할인율 : " + (discount * 100) + "%");
        System.out.println("최종 할인 가격 : " + applyDiscount());
    }


    // TODO: 필요한 경우 부모 클래스의 메소드 오버라이딩


    @Override
    public void info() {
        super.info();
        System.out.println("*현재 할인중인 상품*");
        System.out.println("할인율 : " + (discount * 100) + "%");
        System.out.println("최종 할인 가격 : " + applyDiscount());
    }
}