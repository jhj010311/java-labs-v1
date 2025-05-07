package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Engine 클래스 정의하기
 */
public class Engine {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (엔진 타입, 마력, 작동 상태 등)
    private String engineType;
    private int horsePower;
    private boolean startUp;

    
    
    
    // TODO: 생성자를 정의하세요.
    Engine(String engineType, int horsePower) {
        this.engineType = engineType;
        this.horsePower = horsePower;
        this.startUp = false;
    }
    
    
    
    // TODO: 엔진을 시작하는 메소드를 정의하세요.
    public void startEngine() {
        System.out.println("Engine 클래스에서 엔진 시동");
        startUp = true;
    }
    
    
    
    // TODO: 엔진을 정지하는 메소드를 정의하세요.
    public void stopEngine() {
        System.out.println("Engine 클래스에서 엔진 정지");
        startUp = false;
    }
    
    
    
    // TODO: 엔진의 상태를 확인하는 메소드를 정의하세요.
    public void engineStatus() {
        System.out.println("현재 엔진 시동 상태 : " + startUp);
    }
    
    
    
    // TODO: 엔진의 정보를 출력하는 메소드를 정의하세요.
    public void engineInfo() {
        System.out.println("엔진 타입 : " + engineType);
        System.out.println("마력 : " + horsePower);
        System.out.println("현재 엔진 시동 상태 : " + startUp);
    }
    
    
    
    // TODO: 필요한 getter/setter 메소드를 정의하세요.
    public void getEngineType() {
        System.out.println("getter 메소드 사용");
        System.out.println("엔진 타입 : " + engineType);
    }

    public void getHorsePower() {
        System.out.println("getter 메소드 사용");
        System.out.println("마력 : " + horsePower);
    }
    
    
} 