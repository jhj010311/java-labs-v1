package chapter4.labs.lab1;

/**
 * Lab 1: 클래스와 객체 만들기
 * 
 * Person 클래스 정의하기
 */
public class Person {
    // TODO: 이름, 나이, 성별을 저장할 수 있는 필드를 정의하세요.
    String name;
    int age;
    String gender;


    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    
    // TODO: 객체 정보를 출력하는 메소드를 작성하세요.
    void whatPerson() {
        System.out.println("이름 : " + name + ", 나이 : " + age + ", 성별 : " + gender);

        return;
    }
    
    
    
    // TODO: 생일이 지났을 때 나이를 한 살 증가시키는 메소드를 작성하세요.
    void birthday() {
        System.out.println(name + "의 생일이 지나갑니다");
        age++;

        return;
    }
    
    
} 