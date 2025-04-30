package chapter4.labs.lab1;

/**
 * Lab 1: 클래스와 객체 만들기
 * 
 * Person 클래스를 테스트하는 메인 클래스
 */
public class PersonTest {
    public static void main(String[] args) {
        System.out.println("Person 클래스 테스트를 시작합니다.");
        
        // TODO: 이름이 John, 나이가 20, 성별이 Male인 Person 객체를 생성하세요.
        Person john = new Person("John", 20, "Male");
        System.out.println("Person john = new Person(\"John\", 20, \"Male\"); 실행");
        
        
        // TODO: 생성한 객체의 정보를 출력하세요.
        john.whatPerson();
        
        
        // TODO: 생일이 지나 나이가
        john.birthday();
        john.whatPerson();
        
        
        // TODO: 이름이 Emily, 나이가 25, 성별이 Female인 두 번째 Person 객체를 생성하세요.
        Person emily = new Person("Emily", 25, "Female");
        
        
        // TODO: 두 번째 객체의 정보를 출력하세요.
        System.out.println();
        emily.whatPerson();
        
        
        // TODO: 두 번째 객체의 나이를 증가시키고 정보를 다시 출력하세요.
        emily.age++;
        System.out.println("\nemily.age++; 실행");
        emily.whatPerson();
        
        
        // TODO: 추가로 여러 Person 객체를 생성하여 배열로 관리하고 모든 객체의 정보를 출력하세요.
        Person[] persons = new Person[3];
        persons[0] = john;
        persons[1] = emily;
        persons[2] = new Person("Adam", 30, "Male");


        System.out.println();
        for (Person person : persons) {
            person.whatPerson();
        }
    }
} 