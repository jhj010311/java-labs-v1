package chapter1.labs.lab4;

/**
 * Lab 4: 자바 연산자 실습
 * 
 * 이 실습은 자바의 다양한 연산자를 이해하고 활용하는 것을 목표로 합니다.
 */
public class OperatorsLab {
    public static void main(String[] args) {
        // TODO: 1. 산술 연산자 사용하기
        // 두 개의 정수형 변수를 선언하고 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산을 수행하세요.

        int a = 1;
        int b = 2;

        System.out.println("a + b = " + a + b);
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));


        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");
        
        
        // TODO: 2. 증감 연산자 사용하기
        // 변수를 선언하고 전위 증가, 후위 증가, 전위 감소, 후위 감소 연산을 수행하세요.
        // 각 단계별로 변수의 값을 출력하여 변화를 확인하세요.

        int c = 5;

        System.out.println("c++ = " + c++);
        System.out.println("c = " + c);
        System.out.println("++c = " + ++c);
        System.out.println("c = " + c);
        System.out.println("c-- = " + c--);
        System.out.println("c = " + c);
        System.out.println("--c = " + --c);
        System.out.println("c = " + c);


        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");
        
        
        // TODO: 3. 비교 연산자 사용하기
        // 두 변수를 비교하여 결과를 출력하세요 (==, !=, >, <, >=, <=).

        System.out.println("a == b = " + (a == b));
        System.out.println("a != b = " + (a != b));
        System.out.println("a > b = " + (a > b));
        System.out.println("a < b = " + (a < b));
        System.out.println("a >= b = " + (a >= b));
        System.out.println("a <= b = " + (a <= b));


        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");

        
        
        // TODO: 4. 논리 연산자 사용하기
        // boolean 변수를 사용하여 AND(&&), OR(||), NOT(!) 연산을 수행하세요.

        boolean bool1 = true;
        boolean bool2 = false;

        System.out.println("bool1 && bool2 = " + (bool1 && bool2));
        System.out.println("bool1 || bool2 = " + (bool1 || bool2));
        System.out.println("bool1 != bool2 = " + (bool1 != bool2));


        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");
        
        
        // TODO: 5. 대입 연산자 사용하기
        // 변수를 선언하고 복합 대입 연산자(+=, -=, *=, /=, %=)를 사용하여 값을 변경하세요.

        int aa = 12;

        System.out.println("aa = " + aa);

        aa += 5;
        System.out.println("aa += 5 : " + aa);

        aa -= 3;
        System.out.println("aa -= 3 : " + aa);

        aa *= 4;
        System.out.println("aa *= 4 : " + aa);

        aa /= 2;
        System.out.println("aa /= 2 : " + aa);

        aa %= 10;
        System.out.println("aa %= 10 : " + aa);



        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");
        
        
        // TODO: 6. 삼항 연산자 사용하기
        // 조건에 따라 다른 값을 할당하는 예제를 작성하세요.

        int aaa = 11;
        int bbb = 44;

        System.out.println("aaa = " + aaa);
        System.out.println("bbb = " + bbb);
        System.out.println("(aaa > bbb) ? aaa : bbb");
        System.out.println("결과 : " + ((aaa > bbb) ? aaa : bbb));
        
    }
} 