package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * Electronics 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현합니다.
 */
public class Electronics implements Buyable, Discountable {
    // TODO: 전자제품의 속성 정의 (예: 이름, 가격, 제조사)
    private String name;
    private double price;
    private String manufacturer;

    // TODO: 생성자 정의

    public Electronics(String name, double price, String manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }


    // TODO: Buyable 인터페이스의 메소드 구현

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getProductName() {
        return this.name;
    }

    @Override
    public double getDiscountRate() {
        return 20;
    }

    @Override
    public double getPriceAfterDiscount() {
        return this.getPrice() - (this.getPrice() * this.getDiscountRate());
    }

    // TODO: 전자제품만의 고유한 메소드 추가
    
} 