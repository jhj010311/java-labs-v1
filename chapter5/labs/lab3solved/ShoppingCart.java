package chapter5.labs.lab3solved;

import java.util.ArrayList;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * ShoppingCart 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현한 다양한 상품을 담는 장바구니 역할을 합니다.
 */
public class ShoppingCart {
    // TODO: 상품 목록을 저장할 리스트 선언
    ArrayList<Buyable> cart = new ArrayList<>();
    
    // TODO: 생성자 정의

    // TODO: 장바구니에 상품 추가하는 메소드 구현
    public void addProduct(Buyable product) {
        cart.add(product);
    };
    
    // TODO: 장바구니에서 상품 제거하는 메소드 구현
    public void deleteProduct(Buyable product) {
        cart.remove(product);
    };
    
    // TODO: 장바구니의 총 금액을 계산하는 메소드 구현
    public double totalPrice() {
        double sum = 0;
        for(Buyable p : cart) {
            sum += p.getPrice();
        }
        return sum;
    }
    
    // TODO: 장바구니 상품 목록을 출력하는 메소드 구현
    public void printCartList() {
        System.out.println("===장바구니에 담은 목록===");
        for(Buyable p : cart) {
            System.out.println(p.getProductName());    
        }
    }

    public void printDiscountedProduct() {
        System.out.println("===할인이 들어간 상품만 출력===");
        for(Buyable p : cart) {
            if (p instanceof Discountable) {
                System.out.println(p.getProductName());
            }
        }
    }
    
} 