package chapter4.labs.lab3;

/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * final 키워드 예제 클래스
 */
public class FinalExample {
    // TODO: final 변수를 선언하고 초기화하세요.
    public final int finalInt = 3;
    
    
    // TODO: final 변수를 선언만 하고, 생성자에서 초기화하세요.
    public final int finalInt2;
    
    
    // TODO: 생성자를 정의하세요.
    public FinalExample() {
        // final 변수 초기화
        finalInt2 = 5;
    }
    
    // TODO: final 메소드를 정의하세요.
    public final void finalMethod() {
        System.out.println("finalMethod");
    }
    
    
    // TODO: final 매개변수를 받는 메소드를 정의하세요.
    public void finalMethod2(int n) {
        System.out.println("finalMethod2");
        System.out.println("finalInt2: " + n);
    }
    
    
    public static void main(String[] args) {
        System.out.println("Final 키워드 예제를 실행합니다.");
        
        // TODO: FinalExample 객체를 생성하세요.
        FinalExample finEx =  new FinalExample();
        
        
        // TODO: 객체의 메소드를 호출하세요.
        finEx.finalMethod();
        
        
        // TODO: final 클래스의 객체를 생성하고 메소드를 호출하세요.
        FinalClass finalClass = new FinalClass();
        finalClass.finalMethod();

        
        
        // TODO: final 지역 변수를 선언하고 사용하세요.
        final int instantVar = 7;
        System.out.println("instantVar: " + instantVar);
        
        
    }
}

// TODO: final 클래스를 정의하세요.
final class FinalClass {
    public void finalMethod() {
        System.out.println("finalClass method");
    }
}


// TODO: 일반 클래스와 하위 클래스를 정의하고, final 메소드 오버라이딩을 시도해보세요.
class Parent {
    public final void finalMethod() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    /*@Override
    public final void finalMethod() {
        System.out.println("Child 오버라이드 시도");
    }*/
}