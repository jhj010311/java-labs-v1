package chapter3.labs.lab4;

import java.time.DayOfWeek;
import java.util.Scanner;

/**
 * Enum(열거형) 활용하기 실습
 */
public class EnumLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 요일 Enum 활용하기
        System.out.println("===== 요일 Enum 활용하기 =====");
        System.out.println("요일을 입력하세요 (월, 화, 수, 목, 금, 토, 일): ");
        String input = scanner.nextLine();
        
        // TODO: 입력받은 요일에 해당하는 DayOfWeek Enum 상수를 찾아 switch 문에서 활용하세요.
        // 평일(월~금)인 경우 "평일입니다."를, 주말(토, 일)인 경우 "주말입니다."를 출력하세요.

        String day = "";

        switch (input) {
            case "월":
                day = "MONDAY";
                break;
            case "화":
                day = "TUESDAY";
                break;
            case "수":
                day = "WEDNESDAY";
                break;
            case "목":
                day = "THURSDAY";
                break;
            case "금":
                day = "FRIDAY";
                break;
            case "토":
                day = "SATURDAY";
                break;
            case "일":
                day = "SUNDAY";
                break;
            default:
                System.out.println("잘못된 입력입니다");
        }

        DayOfWeek today = DayOfWeek.valueOf(day);

        switch (today) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("평일입니다");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("주말입니다");
                break;
            default:
                System.out.println("잘못된 입력입니다");
        }
        
        
        // 2. 계절 Enum 활용하기
        System.out.println("\n===== 계절 Enum 활용하기 =====");
        System.out.println("월을 입력하세요 (1-12): ");
        int month = scanner.nextInt();
        
        // TODO: 입력받은 월에 해당하는 Season Enum 상수를 찾아 해당 계절의 특징을 출력하세요.
        // Season Enum에 평균 기온과 특징을 필드로 추가하고, 이를 활용하세요.

        Season2 season = null;

        switch (month) {
            case 12: case 1: case 2:
                season = Season2.WINTER;
                break;
            case 3: case 4: case 5:
                season = Season2.SPRING;
                break;
            case 6: case 7: case 8:
                season = Season2.SUMMER;
                break;
            case 9: case 10: case 11:
                season = Season2.FALL;
                break;
            default:
                System.out.println("잘못된 입력입니다");
        }

        System.out.println(season.getDescription());
        System.out.println(season.getAverageTemperature() + "˚C");
        
        
        // 3. 상태 전이 Enum 활용하기
        System.out.println("\n===== 상태 전이 Enum 활용하기 =====");
        
        // TODO: TaskStatus Enum을 구현하고, 상태 전이 로직을 활용하여 작업 상태를 변경하세요.
        // TaskStatus는 PENDING, IN_PROGRESS, COMPLETED, ARCHIVED 상태를 가지며,
        // nextStatus() 메소드를 통해 다음 상태로 전이할 수 있어야 합니다.
        // 사용자가 "next"를 입력할 때마다 상태를 다음 단계로 변경하고, 현재 상태를 출력하세요.
        // 사용자가 "exit"를 입력하면 종료합니다.

        scanner.nextLine();
        TaskStatusEnum status = TaskStatusEnum.PENDING;
        String nexit = "";

        System.out.println("현재 상태 : " + status);

        while (true) {
            System.out.println("next나 exit을 입력해주세요");

            nexit = scanner.nextLine();
            if(nexit.equals("next")) {
                status = status.nextStatus();
                System.out.println("현재 상태 : " + status);
            } else if (nexit.equals("exit")) {
                System.out.println("종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
        
        
        // 4. 연산자 Enum 활용하기
        System.out.println("\n===== 연산자 Enum 활용하기 =====");
        
        // TODO: Operator Enum을 구현하고, 두 수에 대한 사칙연산을 수행하세요.
        // Operator는 ADD(+), SUBTRACT(-), MULTIPLY(*), DIVIDE(/) 연산을 가지며,
        // calculate() 메소드를 통해 두 수에 대한 연산을 수행할 수 있어야 합니다.
        // 사용자로부터 두 수와 연산자를 입력받아 계산 결과를 출력하세요.

        System.out.println("정수 2개를 입력해주세요");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println("덧셈 : " + Operators.ADD.calculate(num1, num2));
        System.out.println("뺄셈 : " + Operators.SUBTRACT.calculate(num1, num2));
        System.out.println("곱셈 : " + Operators.MULTIPLY.calculate(num1, num2));
        if(num2 == 0){
            System.out.println("나누는 숫자가 0이므로 나눗셈은 실행하지 않음");
        } else {
            System.out.println("나눗셈 : " + Operators.DIVIDE.calculate(num1, num2));
        }

        scanner.close();
    }

}

enum Season2 {
    SPRING("꽃이 피는 계절", 15),
    SUMMER("더운 계절", 28),
    FALL("낙엽이 떨어지는 계절", 18),
    WINTER("추운 계절", 5);

    private final String description;
    private final int averageTemperature;

    // 생성자 (private이 기본값)
    Season2(String description, int averageTemperature) {
        this.description = description;
        this.averageTemperature = averageTemperature;
    }

    // Getter 메소드
    public String getDescription() {
        return description;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }
}

enum TaskStatusEnum {
    PENDING {
        @Override
        public TaskStatusEnum nextStatus() {
            return IN_PROGRESS;
        }
    }, IN_PROGRESS {
        @Override
        public TaskStatusEnum nextStatus() {
            return COMPLETED;
        }
    }, COMPLETED {
        @Override
        public TaskStatusEnum nextStatus() {
            return ARCHIVED;
        }
    }, ARCHIVED {
        @Override
        public TaskStatusEnum nextStatus() {
            return PENDING;
        }
    };

    public abstract TaskStatusEnum nextStatus();
}

enum Operators {
    ADD {
        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    }, SUBTRACT {
        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    }, MULTIPLY {
        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    }, DIVIDE {
        @Override
        public int calculate(int num1, int num2) {
            return num1 / num2;
        }
    };

    public abstract int calculate(int num1, int num2);
}