package chapter5.labs.lab2;

/**
 * Lab 2: 추상 클래스 활용하기
 * 
 * Cat 클래스를 정의하세요.
 * 이 클래스는 Animal 추상 클래스를 상속받아야 합니다.
 */
public class Cat extends Animal {
    // TODO: 고양이의 추가 속성 정의 (예: 털 색깔)
    private String fur;
    
    
    // TODO: 생성자 정의
    public Cat(String name, int age, String fur) {
        super(name, age);
        this.fur = fur;
    }
    
    
    // TODO: 추상 메소드 sound() 구현
    @Override
    public void sound() {
        System.out.println("*고양이 울음소리*");
    }


    // TODO: 필요한 경우 부모 클래스의 메소드 오버라이딩
    @Override
    public void info() {
        super.info();
        System.out.println("털 색깔 : " + fur);
    }


    // TODO: 고양이만의 고유한 메소드 추가
    public void pot() {
        System.out.println("냄비 안에 들어간 고양이" + name);
    }
    
} 