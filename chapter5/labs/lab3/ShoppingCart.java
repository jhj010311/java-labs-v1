package chapter5.labs.lab3;

import javax.swing.plaf.basic.BasicTableHeaderUI;
import java.util.ArrayList;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * ShoppingCart 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현한 다양한 상품을 담는 장바구니 역할을 합니다.
 */
public class ShoppingCart {
    // TODO: 상품 목록을 저장할 리스트 선언
    ArrayList<Buyable> shoppingCart;
    
    
    // TODO: 생성자 정의
    ShoppingCart() {
        shoppingCart = new ArrayList<Buyable>();
    }
    
    
    // TODO: 장바구니에 상품 추가하는 메소드 구현
    public void addBuyable(Buyable buyable) {
        shoppingCart.add(buyable);
    }
    
    
    // TODO: 장바구니에서 상품 제거하는 메소드 구현
    public void removeBuyable(Buyable buyable) {
        shoppingCart.remove(buyable);
    }
    
    
    // TODO: 장바구니의 총 금액을 계산하는 메소드 구현
    public int allPrice() {
        int price = 0;
        for (Buyable buyable : shoppingCart) {
            price += buyable.price();
        }

        return price;
    }
    
    
    // TODO: 장바구니 상품 목록을 출력하는 메소드 구현
    public void printShoppingCart() {
        for (Buyable buyable : shoppingCart) {
            buyable.info();
            System.out.println();
        }
    }
    
} 