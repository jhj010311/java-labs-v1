package chapter5.labs.lab2;

/**
 * Lab 2: 추상 클래스 활용하기
 * 
 * 여러 동물 객체를 생성하고, 각 동물의 정보와 소리를 출력하는 테스트 클래스입니다.
 */
public class AnimalTest {
    public static void main(String[] args) {
        System.out.println("Lab 2: 추상 클래스 활용하기 실습");
        
        // TODO: Dog 객체 생성
        Dog doggy = new Dog("doggy", 4, "골든 리트리버");
        
        
        // TODO: Cat 객체 생성
        Cat tom = new Cat("tom", 3, "gray");
        
        
        // TODO: Bird 객체 생성
        Bird jerry = new Bird("jerry", 6, 15, "eagle");
        
        
        // TODO: 각 동물의 정보와 소리 출력
        doggy.info();
        doggy.sound();
        tom.info();
        tom.sound();
        jerry.info();
        jerry.sound();
        
        
        // TODO: 배열을 사용하여 여러 Animal 객체 관리하기
        Animal[] animals = {doggy, tom, jerry};
        
        
        // TODO: 모든 동물에 대해 반복하여 정보와 소리 출력하기
        for (Animal animal : animals) {
            animal.sound();
        }
        
    }
} 