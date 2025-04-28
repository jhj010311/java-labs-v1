package chapter1.labs.lab2;

/**
 * Lab 2: 자바 데이터 타입 실습
 * 
 * 이 실습은 자바의 기본 데이터 타입을 이해하고 사용하는 것을 목표로 합니다.
 */
public class DataTypesLab {
    public static void main(String[] args) {
        // TODO: 다음 기본 데이터 타입의 변수를 선언하고 값을 할당하세요.
        // 1. 정수형(byte, short, int, long) 변수 선언 및 할당

        byte bytevar = 1;
        short shortvar = 2;
        int intvar = 3;
        long longvar = 4l;
        
        
        // TODO: 2. 실수형(float, double) 변수 선언 및 할당
        float floatvar = 5.0f;
        double doublevar = 6.0;
        
        
        // TODO: 3. 문자형(char) 변수 선언 및 할당
        char charvar = 'a';
        
        
        // TODO: 4. 논리형(boolean) 변수 선언 및 할당
        boolean booleanvar = true;
        
        
        // TODO: 5. 모든 변수 값을 출력하세요.
        System.out.println("byte : " + bytevar);
        System.out.println("short : " + shortvar);
        System.out.println("int : " + intvar);
        System.out.println("long : " + longvar);
        System.out.println("float : " + floatvar);
        System.out.println("double : " + doublevar);
        System.out.println("char : " + charvar);
        System.out.println("boolean : " + booleanvar);


        // TODO: 6. 자신의 키(cm)와 몸무게(kg)를 저장하는 변수를 선언하고 
        // BMI 지수를 계산하여 출력하세요. (BMI = 몸무게(kg) / (키(m) * 키(m)))
        float height = 185f;
        float weight = 70f;

        System.out.println("height : " + height);
        System.out.println("weight : " + weight);

        System.out.println("BMI = " + weight / (height * height / 10000));
    }
} 