package chapter2.labs.lab5;

import java.util.Scanner;

/**
 * 별표(*) 패턴 출력 실습
 */


/*
개선 방향 제안
**"상단+하단을 한 루프로 통합"**하거나,

아니면 최소한 반복 로직을 함수화해서 중복을 줄일 수 있어.
 */


public class StarPatternLab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("패턴 출력을 위한 높이를 입력하세요: ");
        int height = scanner.nextInt();
        
        // 1. 직각삼각형 패턴 (왼쪽 정렬)
        System.out.println("\n1. 직각삼각형 패턴 (왼쪽 정렬)");
        // 예시 (높이 5):
        // *
        // **
        // ***
        // ****
        // *****
        
        // TODO: 위와 같은 패턴을 출력하세요.

        for(int i = 1; i <= height; i++){
            int stars = i;

            for(int j = 0; j < stars; j++){
                System.out.print("*");
            }

            System.out.println();
        }
        
        
        // 2. 직각삼각형 패턴 (오른쪽 정렬)
        System.out.println("\n2. 직각삼각형 패턴 (오른쪽 정렬)");
        // 예시 (높이 5):
        //     *
        //    **
        //   ***
        //  ****
        // *****
        
        // TODO: 위와 같은 패턴을 출력하세요.

        for(int i = 1; i <= height; i++){
            int stars = i;
            int spaces = height - i;

            for(int j = 0; j < spaces; j++){
                System.out.print(" ");
            }

            for(int j = 0; j < stars; j++){
                System.out.print("*");
            }

            System.out.println();
        }
        
        
        // 3. 피라미드 패턴
        System.out.println("\n3. 피라미드 패턴");
        // 예시 (높이 5):
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        
        // TODO: 위와 같은 패턴을 출력하세요.

        for(int i = 1; i <= height; i++){
            int stars = i * 2 - 1;
            int spaces = height - i;

            for(int j = 0; j < spaces; j++){
                System.out.print(" ");
            }

            for(int j = 0; j < stars; j++){
                System.out.print("*");
            }

            System.out.println();
        }
        
        
        // 4. 역삼각형 패턴
        System.out.println("\n4. 역삼각형 패턴");
        // 예시 (높이 5):
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        
        // TODO: 위와 같은 패턴을 출력하세요.

        for(int i = 1; i <= height; i++){
            int stars = (height - i) * 2 + 1;
            int spaces = i - 1;

            for(int j = 0; j < spaces; j++){
                System.out.print(" ");
            }

            for(int j = 0; j < stars; j++){
                System.out.print("*");
            }

            System.out.println();
        }
        
        
        // 5. 다이아몬드 패턴
        System.out.println("\n5. 다이아몬드 패턴");
        // 예시 (높이 5, 실제 높이는 9):
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        
        // TODO: 위와 같은 패턴을 출력하세요.

        int actualH = height * 2 - 1;

        for(int i = 1; i <= actualH; i++){
            int stars = i < height ? (2 * i - 1) : (2 * (actualH - i) + 1);
            int spaces = i < height ? (height - i) : (i - height);

            for(int j = 0; j < spaces; j++){
                System.out.print(" ");
            }

            for(int j = 0; j < stars; j++){
                System.out.print("*");
            }

            System.out.println();
        }
        
        
        // 6. 모래시계 패턴
        System.out.println("\n6. 모래시계 패턴");
        // 예시 (높이 5, 실제 높이는 9):
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        
        // TODO: 위와 같은 패턴을 출력하세요.

        for(int i = 1; i <= height; i++){
            int stars = i < height ? (2 * (height - i) + 1) : (2 * (i - height) + 1);
            int spaces = i < height ? (i - 1) : (actualH - i);

            for(int j = 0; j < spaces; j++){
                System.out.print(" ");
            }

            for(int j = 0; j < stars; j++){
                System.out.print("*");
            }

            System.out.println();
        }
        
        
        // 7. 숫자 피라미드 패턴
        System.out.println("\n7. 숫자 피라미드 패턴");
        // 예시 (높이 5):
        //     1
        //    121
        //   12321
        //  1234321
        // 123454321
        
        // TODO: 위와 같은 패턴을 출력하세요.

        for(int i = 1; i <= height; i++){
            for(int j = height; j > i; j--){
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }

            for(int j = 1; j < i; j++){
                System.out.print(i - j);
            }

            System.out.println();
        }
        
        
        scanner.close();
    }
} 