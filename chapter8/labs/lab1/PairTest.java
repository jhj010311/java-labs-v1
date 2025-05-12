package chapter8.labs.lab1;

import java.util.Scanner;

/**
 * Lab 1: 제네릭 클래스 구현 테스트
 *
 * Pair 클래스와 PairUtils 클래스의 기능을 테스트합니다.
 */
public class PairTest {
    public static void main(String[] args) {
        System.out.println("=== Pair 클래스 테스트 ===");
        
        // TODO: Pair 클래스의 다양한 타입 매개변수를 사용하여 객체를 생성하고 테스트하세요.
        // Integer와 String 타입의 Pair
        Pair<Integer, String> pairIS = new Pair<>(3, "triangle");
        System.out.println("Integer와 String 타입의 Pair 생성 성공");

        // Double과 Double 타입의 Pair
        Pair<Double, Double> pairDD = new Pair<>(3.14, 3.14159);
        System.out.println("Double과 Double 타입의 Pair 생성 성공");

        // 사용자 정의 클래스를 사용한 Pair
        Pair<Pair<Integer, String>, Pair<Double, Double>> pairPP = new Pair<>(pairIS, pairDD);
        System.out.println("사용자 정의 클래스를 사용한 Pair 생성 성공");

        
        System.out.println("\n=== PairUtils 클래스 테스트 ===");
        
        // TODO: PairUtils 클래스의 메소드를 테스트하세요.
        // of 메소드 테스트
        Pair<Integer, Integer> pairII = PairUtils.create(5, 7);
        System.out.println("PairUtils.create 성공");

        
        // swap 메소드 테스트
        Pair<String, Integer> pairSI = PairUtils.swap(pairIS);
        System.out.println("PairUtils.swap 성공");

        
        // 숫자 타입의 sum 메소드 테스트
        double sum = PairUtils.sum(pairII);
        System.out.println("\nint sum = PairUtils.sum(pairII);");
        System.out.println("sum : " + sum);


        
        // 타입 제한 테스트 (Number 하위 클래스만 가능)
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n타입 제한 테스트 (Number 하위 클래스만 가능)");

            Number num1, num2;

            System.out.println("\n숫자1의 타입을 정해주세요");
            System.out.println("1. int 2. byte 3. short");
            System.out.println("4. double 5. float 6. long");
            String type1 = scanner.nextLine();

            System.out.println("\n숫자1을 입력해주세요");

            num1 = switch (type1) {
                case "1" -> Integer.parseInt(scanner.nextLine());
                case "2" -> Byte.parseByte(scanner.nextLine());
                case "3" -> Short.parseShort(scanner.nextLine());
                case "4" -> Double.parseDouble(scanner.nextLine());
                case "5" -> Float.parseFloat(scanner.nextLine());
                case "6" -> Long.parseLong(scanner.nextLine());
                default -> {
                    System.out.println("int 입력으로 판단합니다");
                    yield Integer.parseInt(scanner.nextLine());
                }
            };

            System.out.println("\n숫자2의 타입을 정해주세요");
            System.out.println("1. int 2. byte 3. short");
            System.out.println("4. double 5. float 6. long");
            String type2 = scanner.nextLine();

            System.out.println("\n숫자1을 입력해주세요");

            num2 = switch (type2) {
                case "1" -> Integer.parseInt(scanner.nextLine());
                case "2" -> Byte.parseByte(scanner.nextLine());
                case "3" -> Short.parseShort(scanner.nextLine());
                case "4" -> Double.parseDouble(scanner.nextLine());
                case "5" -> Float.parseFloat(scanner.nextLine());
                case "6" -> Long.parseLong(scanner.nextLine());
                default -> {
                    System.out.println("int 입력으로 판단합니다");
                    yield Integer.parseInt(scanner.nextLine());
                }
            };

            System.out.println("\n입력된 숫자로 Pair 객체 생성");
            Pair<? extends Number, ? extends Number> pair = PairUtils.create(num1, num2);
            System.out.println("Pair<? extends Number, ? extends Number> pair = PairUtils.create(num1, num2);");
            System.out.println("pair : " + pair);
        }
        
        // 와일드카드 메소드 테스트
        System.out.println("\nPair<Integer, String> pairIS = new Pair<>(3, \"triangle\");");
        System.out.println(pairIS);

        System.out.println("\nPair<Double, Double> pairDD = new Pair<>(3.14, 3.14159);");
        System.out.println(pairDD);

        System.out.println("\nPair pairPP = new Pair<>(pairIS, pairDD);");
        System.out.println(pairPP);

        System.out.println("\nPair<Integer, Integer> pairII = PairUtils.create(5, 7);");
        System.out.println(pairII);

        System.out.println("\nPair<String, Integer> pairSI = PairUtils.swap(pairIS);");
        System.out.println(pairSI);
    }
} 