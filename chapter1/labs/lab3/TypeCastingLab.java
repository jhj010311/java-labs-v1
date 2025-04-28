package chapter1.labs.lab3;

/**
 * Lab 3: 자바 타입 변환(Type Casting) 실습
 * 
 * 이 실습은 자바의 타입 변환에 대해 이해하고 실습하는 것을 목표로 합니다.
 */
public class TypeCastingLab {
    public static void main(String[] args) {
        // TODO: 1. 자동 형변환(Implicit Casting) 예제
        // byte -> int, int -> long, long -> float, float -> double 순으로 
        // 변수를 선언하고 자동 형변환을 수행한 뒤 결과 출력하기

        byte bytevar = 10;
        int intvar = bytevar;
        long longvar = intvar;
        float floatvar = longvar;
        double doublevar = floatvar;

        System.out.println("bytevar : " + bytevar);
        System.out.println("intvar : " + intvar);
        System.out.println("longvar : " + longvar);
        System.out.println("floatvar : " + floatvar);
        System.out.println("doublevar : " + doublevar);


        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");
        
        
        // TODO: 2. 명시적 형변환(Explicit Casting) 예제
        // double -> float -> long -> int -> char -> short -> byte 순으로
        // 변수를 선언하고 명시적 형변환을 수행한 뒤 결과 출력하기

        double doublevar2 = 13;
        float floatvar2 = (float) doublevar2;
        long longvar2 = (long) floatvar2;
        int intvar2 = (int) longvar2;
        char charvar2 = (char) intvar2;
        short shortvar2 = (short) intvar2;
        byte bytevar2 = (byte) shortvar2;

        System.out.println("doublevar2 : " + doublevar2);
        System.out.println("floatvar2 : " + floatvar2);
        System.out.println("longvar2 : " + longvar2);
        System.out.println("intvar2 : " + intvar2);
        System.out.println("charvar2 : " + charvar2);
        System.out.println("shortvar2 : " + shortvar2);
        System.out.println("bytevar2 : " + bytevar2);


        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");


        // TODO: 3. 데이터 손실 확인하기
        // int 값을 byte로 변환하여 데이터 손실이 발생하는 예제 작성하기

        int intvar3 = 300;
        byte bytevar3 = (byte) intvar3;

        System.out.println("intvar3 : " + intvar3);
        System.out.println("bytevar3 : " + bytevar3);


        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");

        
        // TODO: 4. 문자열과 숫자 간 변환하기
        // 문자열 "123"을 정수로, "3.14"를 실수로 변환하기

        String strvar4 = "123";
        int intvar4 = Integer.parseInt(strvar4);
        System.out.println("strvar4 : " + strvar4);
        System.out.println("intvar4 : " + intvar4);

        String strvar5 = "3.14";
        double doublevar5 = Double.parseDouble(strvar5);

        System.out.println("strvar5 : " + strvar5);
        System.out.println("doublevar5 : " + doublevar5);
        
        
        // TODO: 5. 숫자를 문자열로 변환하기
        // 정수 456과 실수 7.89를 문자열로 변환하기

        String strvar6 = Integer.toString(456);
        String strvar7 = Double.toString(7.89);

        System.out.println("strvar6 : " + strvar6);
        System.out.println("strvar7 : " + strvar7);

        
    }
} 