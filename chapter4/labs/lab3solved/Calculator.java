package chapter4.labs.lab3solved;

/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * Calculator 클래스 정의하기
 */
public class Calculator {
    // TODO: PI 값을 나타내는 static final 상수를 정의하세요.
    public static final double PI = 3.14;
    
    // TODO: 인스턴스 변수를 정의하세요. (계산기 모델명, 계산 횟수 등)
    public String model;
    public int calcCount;
    
    // TODO: 계산기 객체의 총 개수를 나타내는 static 변수를 정의하세요.
    private static int instanceSize = 0;
    
    // TODO: 생성자를 정의하고, 객체가 생성될 때마다 계산기 개수를 증가시키세요.

    public Calculator(String model) {
        this.model = model;
        instanceSize++;
    }


    // TODO: 원의 면적을 계산하는 static 메소드를 정의하세요.
    public static double calcCircleArea(double r) {
        return r * r * PI;
    }
    
    // TODO: 원의 둘레를 계산하는 static 메소드를 정의하세요.
    
    
    // TODO: 사각형의 면적을 계산하는 static 메소드를 정의하세요.
    
    
    // TODO: 인스턴스 메소드를 정의하고, 해당 메소드가 호출될 때마다 계산 횟수를 증가시키세요.
    public void increaseCalcCount() {
        calcCount++;
    }
    
    // TODO: 계산기의 정보를 출력하는 메소드를 정의하세요.
    public String printCalcInfo() {
        return "계산기 모델 : " + this.model + ", 계산 횟수 : " + this.calcCount;
    }
    
    // TODO: 현재까지 생성된 계산기의 총 개수를 반환하는 static 메소드를 정의하세요.
    public static int sizeOfCalculators() {
        return instanceSize;
    }
    
    
} 