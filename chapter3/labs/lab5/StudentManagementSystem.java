package chapter3.labs.lab5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 학생 성적 관리 프로그램 (종합 프로젝트)
 */
public class StudentManagementSystem {
    // TODO: 학생 성적 등급을 나타내는 Grade Enum을 정의하세요.
    // A(90-100), B(80-89), C(70-79), D(60-69), F(0-59) 등급이 있어야 합니다.
    
    // 최대 학생 수
    private static final int MAX_STUDENTS = 100;
    
    // 학생 정보 배열
    private static String[] names = new String[MAX_STUDENTS]; // 이름 배열
    private static int[] scores = new int[MAX_STUDENTS]; // 성적 배열
    private static int studentCount = 0; // 현재 저장된 학생 수
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("===== 학생 성적 관리 프로그램 =====");
        
        while (running) {
            printMenu();
            int choice = getMenuChoice(scanner);
            
            switch (choice) {
                case 1:
                    // TODO: 성적 입력 기능을 구현하세요.
                    // 학생 이름과 성적을 입력받아 배열에 저장합니다.
                    System.out.println("(학생 성적) 형식으로 입력해주십시오  (ex) 홍길동 96");
                    System.out.println("입력을 중단하시려면 exit을 입력해주십시오");

                    while (studentCount < MAX_STUDENTS) {
                        String input = scanner.nextLine();
                        String[] splitted = input.split(" ");

                        if (splitted[0].equals("exit")) {
                            break;
                        } else {
                            names[studentCount] = splitted[0];
                            scores[studentCount] = Integer.parseInt(splitted[1]);
                            studentCount++;
                        }
                    }

                    System.out.println("성적 입력이 종료되었습니다\n");
                    
                    break;
                case 2:
                    // TODO: 성적 수정 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적을 수정합니다.
                    System.out.println("학생의 이름을 입력해주십시오");

                    String input = scanner.nextLine();
                    boolean found = false;

                    for (int i  = 0; i < MAX_STUDENTS; i++) {
                        if (names[i].equals(input)) {
                            found = true;
                            System.out.println("성적을 입력해주십시오");
                            scores[i] = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("성적 수정이 정상적으로 완료되었습니다");
                        }
                    }
                    
                    if (!found) {
                        System.out.println("해당하는 학생을 찾지 못했습니다");
                    }

                    System.out.println("성적 수정이 종료되었습니다");
                    
                    break;
                case 3:
                    // TODO: 성적 조회 기능을 구현하세요.
                    // 모든 학생의 이름, 성적, 등급을 출력합니다.
                    // 전체 성적의 합계, 평균, 최고 성적, 최저 성적도 출력합니다.
                    System.out.println("성적 조회를 시작합니다\n");

                    System.out.println("이름\t\t성적\t\t등급");

                    for (int i = 0; i < MAX_STUDENTS; i++) {
                        System.out.println(names[i] + "\t\t" + scores[i] + "\t\t" + getGradeFromScore(scores[i]));
                    }

                    int sum = getScoreSum(scores);

                    System.out.println("\n전체 성적 합계 : " + sum);
                    System.out.println("전체 성적 평균 : " + getAverage(sum));
                    System.out.println("최고 성적 : " + getMaxScore(scores));
                    System.out.println("최저 성적 : " + getMinScore(scores));

                    System.out.println("\n성적 조회 종료");

                    break;
                case 4:
                    // TODO: 검색 기능을 구현하세요.
                    // 학생 이름을 입력받아 해당 학생의 성적과 등급을 조회합니다.
                    System.out.println("성적 검색을 시작합니다");
                    System.out.println("학생 이름을 입력해주세요");

                    String search = scanner.nextLine();

                    int index = getIndexByName(search);

                    if(index != -1) {
                        System.out.println(names[index] + "\t\t" + scores[index] + "\t\t" + getGradeFromScore(scores[index]));
                    } else {
                        System.out.println("해당하는 학생이 없습니다");
                    }

                    System.out.println("성적 검색 종료");
                    
                    break;
                case 5:
                    // TODO: 통계 기능을 구현하세요.
                    // 등급별 학생 수와 비율을 출력합니다.
                    System.out.println("통계 출력을 시작합니다\n");

                    int[] gradeCount = new int[5];

                    for (int i = 0; i < MAX_STUDENTS; i++) {
                        Grade grade = getGradeFromScore(scores[i]);

                        switch (grade) {
                            case A:
                                gradeCount[0]++;
                                break;
                            case B:
                                gradeCount[1]++;
                                break;
                            case C:
                                gradeCount[2]++;
                                break;
                            case D:
                                gradeCount[3]++;
                                break;
                            case F:
                                gradeCount[4]++;
                                break;
                            default:
                                System.out.println("등급 오류 발생 >> " + names[i] + "(" + i + ")");
                        }
                    }

                    System.out.println("A등급 : " + gradeCount[0] + "명, " + (gradeCount[0] / studentCount * 100) + "%");
                    System.out.println("B등급 : " + gradeCount[1] + "명, " + (gradeCount[1] / studentCount * 100) + "%");
                    System.out.println("C등급 : " + gradeCount[2] + "명, " + (gradeCount[2] / studentCount * 100) + "%");
                    System.out.println("D등급 : " + gradeCount[3] + "명, " + (gradeCount[3] / studentCount * 100) + "%");
                    System.out.println("F등급 : " + gradeCount[4] + "명, " + (gradeCount[4] / studentCount * 100) + "%");

                    System.out.println("\n통계 출력 종료");
                    
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // 메뉴 출력 메소드
    private static void printMenu() {
        System.out.println("\n===== 메뉴 =====");
        System.out.println("1. 성적 입력");
        System.out.println("2. 성적 수정");
        System.out.println("3. 성적 조회");
        System.out.println("4. 학생 검색");
        System.out.println("5. 통계 보기");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
    
    // 메뉴 선택 입력 메소드
    private static int getMenuChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1; // 잘못된 입력
        } finally {
            scanner.nextLine(); // 버퍼 비우기
        }
    }
    
    // TODO: 성적으로부터 등급을 계산하는 메소드를 구현하세요.
    // 입력받은 성적에 따라 Grade Enum 상수를 반환합니다.

    private static Grade getGradeFromScore(int score) {
        return Grade.getGradeFromScore(score);
    }
    
    
    // TODO: 전체 성적의 합계를 계산하는 메소드를 구현하세요.
    private static int getScoreSum(int[] scores) {
        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        return sum;
    }
    
    
    // TODO: 전체 성적의 평균을 계산하는 메소드를 구현하세요.
    private static float getAverage(int sum) {
        return (float) sum / studentCount;
    }
    
    
    // TODO: 최고 성적을 찾는 메소드를 구현하세요.
    private static int getMaxScore(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        return max;
    }
    
    
    // TODO: 최저 성적을 찾는 메소드를 구현하세요.
    private static int getMinScore(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }

        return min;
    }
    
    
    // TODO: 학생 이름으로 배열에서 위치(인덱스)를 찾는 메소드를 구현하세요.
    private static int getIndexByName(String search) {
        for (int i = 0; i < MAX_STUDENTS; i++) {
            if (names[i].equals(search)) {
                return i;
            }
        }

        return -1;
    }
    
    
}