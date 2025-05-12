package chapter3.labs.lab5solved;

import java.util.Scanner;

/**
 * 학생 성적 관리 프로그램 (종합 프로젝트)
 */
public class StudentManagementSystem {
    // Grade Enum 정의
    enum Grade {
        A, B, C, D, F
    }

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
                    inputScore(scanner);
                    break;
                case 2:
                    modifyScore(scanner);
                    break;
                case 3:
                    viewAllScores();
                    break;
                case 4:
                    searchStudent(scanner);
                    break;
                case 5:
                    showStatistics();
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

    // 성적 입력 기능
    private static void inputScore(Scanner scanner) {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("더 이상 학생을 추가할 수 없습니다. 최대 학생 수에 도달했습니다.");
            return;
        }

        System.out.print("학생 이름을 입력하세요: ");
        String name = scanner.nextLine();

        // 이미 존재하는 학생인지 확인
        int existingIndex = findStudentIndex(name);
        if (existingIndex != -1) {
            System.out.println("이미 등록된 학생입니다. 성적 수정 메뉴를 이용해주세요.");
            return;
        }

        int score = getValidScore(scanner);
        if (score == -1) return; // 유효하지 않은 점수 입력 시 종료

        // 학생 정보 저장
        names[studentCount] = name;
        scores[studentCount] = score;
        studentCount++;

        System.out.println(name + " 학생의 성적(" + score + "점)이 등록되었습니다.");
    }

    // 유효한 점수를 입력받는 메소드
    private static int getValidScore(Scanner scanner) {
        int score;
        while (true) {
            System.out.print("성적을 입력하세요(0-100): ");
            try {
                score = Integer.parseInt(scanner.nextLine());
                if (score >= 0 && score <= 100) {
                    return score;
                } else {
                    System.out.println("성적은 0부터 100 사이의 값이어야 합니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력해주세요.");
            }
        }
    }

    // 성적 수정 기능
    private static void modifyScore(Scanner scanner) {
        if (studentCount == 0) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        System.out.print("수정할 학생의 이름을 입력하세요: ");
        String name = scanner.nextLine();

        int index = findStudentIndex(name);
        if (index == -1) {
            System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
            return;
        }

        System.out.println("현재 " + name + " 학생의 성적은 " + scores[index] + "점입니다.");
        int score = getValidScore(scanner);
        if (score == -1) return; // 유효하지 않은 점수 입력 시 종료

        scores[index] = score;
        System.out.println(name + " 학생의 성적이 " + score + "점으로 수정되었습니다.");
    }

    // 성적 조회 기능
    private static void viewAllScores() {
        if (studentCount == 0) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        System.out.println("\n===== 전체 학생 성적 =====");
        System.out.println("이름\t성적\t등급");
        System.out.println("--------------------");

        for (int i = 0; i < studentCount; i++) {
            Grade grade = calculateGrade(scores[i]);
            System.out.println(names[i] + "\t" + scores[i] + "\t" + grade);
        }

        // 통계 정보 출력
        System.out.println("--------------------");
        System.out.println("총 학생 수: " + studentCount + "명");
        System.out.println("전체 성적 합계: " + calculateSum() + "점");
        System.out.println("전체 성적 평균: " + String.format("%.2f", calculateAverage()) + "점");
        System.out.println("최고 성적: " + findMaxScore() + "점");
        System.out.println("최저 성적: " + findMinScore() + "점");
    }

    // 학생 검색 기능
    private static void searchStudent(Scanner scanner) {
        if (studentCount == 0) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        System.out.print("검색할 학생의 이름을 입력하세요: ");
        String name = scanner.nextLine();

        int index = findStudentIndex(name);
        if (index == -1) {
            System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
            return;
        }

        Grade grade = calculateGrade(scores[index]);
        System.out.println("\n===== 학생 정보 =====");
        System.out.println("이름: " + names[index]);
        System.out.println("성적: " + scores[index] + "점");
        System.out.println("등급: " + grade);
    }

    // 통계 기능
    private static void showStatistics() {
        if (studentCount == 0) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        // 등급별 학생 수 계산
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int i = 0; i < studentCount; i++) {
            Grade grade = calculateGrade(scores[i]);
            switch (grade) {
                case A: countA++; break;
                case B: countB++; break;
                case C: countC++; break;
                case D: countD++; break;
                case F: countF++; break;
            }
        }

        System.out.println("\n===== 등급별 통계 =====");
        System.out.println("A 등급: " + countA + "명 (" + String.format("%.2f", (countA * 100.0 / studentCount)) + "%)");
        System.out.println("B 등급: " + countB + "명 (" + String.format("%.2f", (countB * 100.0 / studentCount)) + "%)");
        System.out.println("C 등급: " + countC + "명 (" + String.format("%.2f", (countC * 100.0 / studentCount)) + "%)");
        System.out.println("D 등급: " + countD + "명 (" + String.format("%.2f", (countD * 100.0 / studentCount)) + "%)");
        System.out.println("F 등급: " + countF + "명 (" + String.format("%.2f", (countF * 100.0 / studentCount)) + "%)");

        System.out.println("\n전체 성적 평균: " + String.format("%.2f", calculateAverage()) + "점");
    }

    // 성적으로부터 등급을 계산하는 메소드
    private static Grade calculateGrade(int score) {
        if (score >= 90) return Grade.A;
        else if (score >= 80) return Grade.B;
        else if (score >= 70) return Grade.C;
        else if (score >= 60) return Grade.D;
        else return Grade.F;
    }

    // 전체 성적의 합계를 계산하는 메소드
    private static int calculateSum() {
        int sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += scores[i];
        }
        return sum;
    }

    // 전체 성적의 평균을 계산하는 메소드
    private static double calculateAverage() {
        if (studentCount == 0) return 0;
        return (double) calculateSum() / studentCount;
    }

    // 최고 성적을 찾는 메소드
    private static int findMaxScore() {
        if (studentCount == 0) return 0;

        int max = scores[0];
        for (int i = 1; i < studentCount; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    // 최저 성적을 찾는 메소드
    private static int findMinScore() {
        if (studentCount == 0) return 0;

        int min = scores[0];
        for (int i = 1; i < studentCount; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

    // 학생 이름으로 배열에서 위치(인덱스)를 찾는 메소드
    private static int findStudentIndex(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        return -1; // 찾지 못한 경우
    }
}