package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Driver 클래스 정의하기 (Car를 사용하는 관계)
 */
public class Driver {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (이름, 운전 경력 등)
    private String name;
    private int license;
    
    
    
    // TODO: 생성자를 정의하세요.
    Driver(String name, int license) {
        this.name = name;
        this.license = license;
    }
    
    
    
    // TODO: 자동차를 운전하는 메소드를 정의하세요.
    // (Car 객체를 매개변수로 받아 사용 관계 구현)
    public void drive(Car car) {
        System.out.println(name + " 운전자가 " + car.getModel() + " 차량을 운전중");
        car.accelerate(20);
        car.decelerate(20);
    }
    
    
    
    // TODO: 자동차를 점검하는 메소드를 정의하세요.
    // (Car 객체를 매개변수로 받아 사용 관계 구현)
    public void check(Car car) {
        System.out.println(name + " 운전자가 차량 점검 시작");
        car.carInfo();
        System.out.println("점검 종료");
    }
    
    
    
    // TODO: 운전자의 정보를 출력하는 메소드를 정의하세요.
    public void driverInfo() {
        System.out.println("운전자명 : " + name);
        System.out.println("운전 경력 : " + license + "년");
    }
    
    
} 