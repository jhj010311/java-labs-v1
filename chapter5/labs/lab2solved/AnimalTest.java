package chapter5.labs.lab2solved;

/**
 * Lab 2: 추상 클래스 활용하기
 * 
 * 여러 동물 객체를 생성하고, 각 동물의 정보와 소리를 출력하는 테스트 클래스입니다.
 */
public class AnimalTest {
    public static void main(String[] args) {
        System.out.println("Lab 2: 추상 클래스 활용하기 실습");
        
        // TODO: Dog 객체 생성
        Dog dog = new Dog();
//        dog.sound();

        // TODO: Cat 객체 생성
        Cat cat = new Cat();
//        cat.sound();

        // TODO: Bird 객체 생성
        Bird bird = new Bird();
//        bird.sound();

        Animal animal = bird;
        animal.sound();
        ((Dog)animal).sound();


        // TODO: 각 동물의 정보와 소리 출력
        
        
        // TODO: 배열을 사용하여 여러 Animal 객체 관리하기
        
        
        // TODO: 모든 동물에 대해 반복하여 정보와 소리 출력하기
        
    }
} 