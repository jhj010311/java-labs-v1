package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Car 클래스 정의하기 (Engine을 포함하는 관계)
 */
public class Car {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (모델명, 색상, 속도, Engine 타입의 필드 등)
    private String model;
    private String color;;
    private int speed = 0;
    private Engine engine;

    
    
    
    // TODO: 생성자를 정의하세요.
    // (Engine 객체를 생성하여 포함관계 구현)
    Car(String model, String color, String engineType, int horsePower) {
        this.model = model;
        this.color = color;
        this.engine = new Engine(engineType, horsePower);
    }
    
    
    
    // TODO: 자동차를 시동하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 메소드 호출)
    public void startUp() {
        System.out.println("Car 클래스에서 자동차 시동");
        engine.startEngine();
    }
    
    
    
    // TODO: 자동차를 정지하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 메소드 호출)
    public void stop() {
        System.out.println("Car 클래스에서 자동차 정지");
        engine.stopEngine();
    }
    
    
    
    // TODO: 자동차의 속도를 증가시키는 메소드를 정의하세요.
    public void accelerate(int speed) {
        System.out.println("Car 클래스에서 가속 명령");
        this.speed += speed;
    }
    
    
    
    // TODO: 자동차의 속도를 감소시키는 메소드를 정의하세요.
    public void decelerate(int speed) {
        System.out.println("Car 클래스에서 감속 명령");
        if(this.speed > speed){
            this.speed -= speed;
        } else {
            this.speed = 0;
        }

    }
    
    
    // TODO: 자동차의 정보를 출력하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 정보도 출력)
    public void carInfo() {
        System.out.println("모델 : " + model);
        System.out.println("색상 : " + color);
        System.out.println("현재 속도 : " + speed);
        System.out.println("엔진 정보 >> ");
        engine.engineInfo();
    }
    
    
    
    // TODO: 필요한 getter/setter 메소드를 정의하세요.
    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }
    
    public void getEngineInfo() {
        System.out.println("getter 메소드 사용");
        System.out.println("엔진 정보 >> ");
        engine.engineInfo();
    }
} 