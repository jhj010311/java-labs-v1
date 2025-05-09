package chapter7.labs.lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 텍스트 파일을 생성하고 처리하는 실습
 *
 * 이 실습에서는 Java의 파일 입출력 기능을 활용하여
 * 텍스트 파일을 생성, 읽기, 검색, 수정하는 다양한 작업을 수행합니다.
 */
public class TextFileIOLab {
    // 파일 경로 상수
    private static final String FILE_PATH = "chapter7/labs/lab2/sample.txt";

    public static void main(String[] args) {
        // TODO: 사용자 입력을 받기 위한 Scanner 객체를 생성하세요.

        Scanner sc = new Scanner(System.in);

        // TODO: 프로그램 메인 루프를 구현하세요.
        // 1. showMenu() 메소드를 호출하여 메뉴 표시
        // 2. getIntInput() 메소드를 호출하여 사용자 선택 받기 (1~7 사이의 값)
        // 3. switch 문을 사용하여 사용자 선택에 따른 메소드 호출
        //    - 1: createTextFile()
        //    - 2: readTextFile()
        //    - 3: searchTextInFile()
        //    - 4: replaceTextInFile()
        //    - 5: countFileStats()
        //    - 6: appendToFile()
        //    - 7: 프로그램 종료
        // 4. 계속하려면 Enter 키를 누르도록 안내 메시지 출력

        boolean loop = true;
        while (loop) {
            showMenu();

            switch (getIntInput(sc, 1, 7)) {
                case 1:
                    createTextFile(sc);
                    break;
                case 2:
                    readTextFile();
                    break;
                case 3:
                    searchTextInFile(sc);
                    break;
                case 4:
                    replaceTextInFile(sc);
                    break;
                case 5:
                    countFileStats();
                    break;
                case 6:
                    //appendToFile(sc);
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
            }

            System.out.println("계속하려면 Enter를 눌러주세요...");
            sc.nextLine();
        }
    }

    /**
     * 메뉴 출력
     */
    private static void showMenu() {
        // TODO: 텍스트 파일 처리 프로그램의 메뉴를 출력하세요.
        // 1. 텍스트 파일 생성하기
        // 2. 텍스트 파일 읽기
        // 3. 텍스트 파일에서 검색하기
        // 4. 텍스트 파일에서 문자열 치환하기
        // 5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)
        // 6. 파일에 내용 추가하기
        // 7. 종료

        System.out.println("메인 메뉴입니다");
        System.out.println("사용하실 기능을 선택해주세요");
        System.out.println("1. 텍스트 파일 생성하기\t2. 텍스트 파일 읽기\t3. 텍스트 파일에서 검색하기");
        System.out.println("4. 텍스트 파일에서 문자열 치환하기\t5. 파일 통계 계산하기\t6. 파일에 내용 추가하기");
        System.out.println("7. 종료");
    }

    /**
     * 사용자로부터 정수 입력 받기
     */
    private static int getIntInput(Scanner scanner, int min, int max) {
        // TODO: 사용자로부터 min과 max 사이의 정수를 입력받아 반환하세요.
        // 1. 사용자 입력을 정수로 변환 시도
        // 2. 입력값이 min과 max 사이의 값인지 확인
        // 3. 잘못된 입력이 들어온 경우 적절한 메시지 출력 후 다시 입력 요청
        // 4. 유효한 입력을 받을 때까지 반복

        int menu = Integer.parseInt((scanner.nextLine()));

        if(menu < min || menu > max) {
            System.out.println("1부터 7까지의 번호를 입력해주세요");
            return 0;
        }

        return menu; // 구현 후 이 줄을 수정하세요.
    }

    /**
     * 텍스트 파일 생성
     */
    private static void createTextFile(Scanner scanner) {
        // TODO: "텍스트 파일 생성하기" 타이틀을 출력하세요.
        System.out.println("\n텍스트 파일 생성하기");

        // TODO: 파일이 이미 존재하는지 확인하세요.
        // 1. File 객체를 생성하고 exists() 메소드를 사용하여 확인
        // 2. 파일이 이미 존재하면 덮어쓸지 사용자에게 물어보기
        // 3. 사용자가 'n'을 입력하면 메소드 종료
        File file = new File(FILE_PATH);
        if(file.exists()) {
            System.out.println("파일이 이미 존재합니다");
            System.out.println("덮어쓰시겠습니까? (Y/N)");

            if(scanner.nextLine().equalsIgnoreCase("N")) {
                return;
            }
        }

        // TODO: 사용자로부터 파일에 저장할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장
        System.out.println("\n파일에 쓸 내용을 입력해주세요");

        int lineCount = 0;
        List<String> lines = new ArrayList<>();

        while(true) {
            String line = scanner.nextLine();

            if(line.equals("")) {
                break;
            }

            line = ++lineCount + ". " + line;
            lines.add(line);
        }

        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter와 BufferedWriter 생성
        // 3. 리스트의 각 줄을 파일에 쓰기 (newLine() 메소드 활용)
        // 4. 예외 처리 및 성공 메시지 출력

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for(String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("파일 작성 중 오류 발생");
            System.out.println(e.getMessage());

            return;
        }

        System.out.println("파일 작성 완료");
    }

    /**
     * 텍스트 파일 읽기
     */
    private static void readTextFile() {
        // TODO: "텍스트 파일 읽기" 타이틀을 출력하세요.
        System.out.println("텍스트 파일 읽기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        if(!file.exists()) {
            System.out.println("파일이 존재하지 않습니다\n");

            return;
        }


        // TODO: BufferedReader를 사용하여 파일 내용을 읽고 출력하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileReader와 BufferedReader 생성
        // 3. readLine() 메소드를 사용하여 한 줄씩 읽기
        // 4. 각 줄 앞에 줄 번호 붙여서 출력
        // 5. 예외 처리 및 완료 메시지 출력

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류 발생");
            System.out.println(e.getMessage());
        }

        System.out.println("\n\n파일 읽기 완료");
    }

    /**
     * 텍스트 파일에서 문자열 검색
     */
    private static void searchTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 검색하기" 타이틀을 출력하세요.
        System.out.println("텍스트 파일에서 검색하기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        if(!file.exists()) {
            System.out.println("파일이 존재하지 않습니다\n");

            return;
        }

        // TODO: 사용자로부터 검색할 텍스트와 대소문자 구분 여부를 입력받으세요.
        System.out.println("\n검색할 텍스트를 입력해주세요");
        String search = scanner.nextLine();

        System.out.println("\n대소문자를 구분하시겠습니까? (Y/N)");
        String dontignore = scanner.nextLine();

        // TODO: BufferedReader를 사용하여 파일을 읽으면서 검색어 찾기
        // 1. try-with-resources 구문 사용
        // 2. 대소문자 구분 여부에 따라 검색 전략 결정
        // 3. 일치하는 부분 찾으면 해당 줄 출력 (검색어 하이라이트)
        // 4. Pattern, Matcher 클래스를 활용하여 검색어 하이라이트
        // 5. 검색 결과 통계 출력 (몇 개의 일치 항목을 찾았는지)
        // 6. 예외 처리

        int searchCount = 0;
        String line;

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Pattern pattern = null;

            if(dontignore.equalsIgnoreCase("Y")) {
                pattern = Pattern.compile(Pattern.quote(search));
            } else if(dontignore.equalsIgnoreCase("N")) {
                pattern = Pattern.compile(Pattern.quote(search), Pattern.CASE_INSENSITIVE);
            }

            while((line = reader.readLine()) != null) {
                if(line.contains(search)) {
                    Matcher matcher = pattern.matcher(line);
                    StringBuffer result = new StringBuffer();

                    while (matcher.find()) {
                        String match = matcher.group();
                        matcher.appendReplacement(result, "<" + ++searchCount + ">" + match + "</" + searchCount + ">");
                    }

                    matcher.appendTail(result);

                    System.out.println(result.toString());
                    }
            }

            System.out.println("\n검색된 검색어 수 : " + searchCount);
        } catch (IOException e) {
            System.out.println("검색 중 오류 발생");
            System.out.println(e.getMessage());
        }
    }

    /**
     * 텍스트 파일에서 문자열 치환
     */
    private static void replaceTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 문자열 치환하기" 타이틀을 출력하세요.
        System.out.println("텍스트 파일에서 문자열 치환하기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        if(!file.exists()) {
            System.out.println("파일이 존재하지 않습니다\n");

            return;
        }

        // TODO: 사용자로부터 다음 정보를 입력받으세요:
        // 1. 찾을 텍스트
        // 2. 변경할 텍스트
        // 3. 대소문자 구분 여부 (y/n)
        // 4. 모든 일치 항목 변경 또는 첫 일치 항목만 변경 여부 (y/n)
        System.out.println("찾을 텍스트를 입력해주세요");
        String search = scanner.nextLine();

        System.out.println("변경할 텍스트를 입력해주세요");
        String replace = scanner.nextLine();

        System.out.println("대소문자를 구분하시겠습니까? (Y/N)");
        String dontignore = scanner.nextLine();
        // y / n 이외가 입력된 경우의 처리 생략

        System.out.println("모든 일치 항목을 변경하시겠습니까? (Y/N)");
        System.out.println("(N을 입력하시면 처음 검색된 한 개만 변경합니다)");
        String replaceAll = scanner.nextLine();
        // y / n 이외가 입력된 경우의 처리 생략


        // TODO: 파일 내용을 List<String>으로 읽어오세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedReader를 사용하여 모든 줄을 리스트에 저장
        List<String> text = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while((line = reader.readLine()) != null) {
                text.add(line);
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류 발생");
            System.out.println(e.getMessage());
        }

        // TODO: 각 줄에서 검색어를 찾아 치환하세요.
        // 1. 대소문자 구분 여부와 모든/첫 일치 항목 변경 여부에 따라 적절한 메소드 사용
        //    - String.replace() 또는 String.replaceAll()
        //    - 정규식 패턴 사용 시 Pattern.CASE_INSENSITIVE 플래그 활용
        // 2. 몇 개의 라인이 변경되었는지 카운트
        int replaceCount = 0;

        for(int i = 0; i < text.size(); i++) {
            String line = text.get(i);
            if(line.contains(search)) {
                replaceCount++;

                if(replaceAll.equalsIgnoreCase("N")) {
                    line = line.replace(search, replace);
                    break;
                }

                Pattern pattern = Pattern.compile(Pattern.quote(search), Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                StringBuffer result = new StringBuffer();

                while (matcher.find()) {
                    String match = matcher.group();
                    matcher.appendReplacement(result, replace);
                }

                matcher.appendTail(result);
                text.set(i, result.toString());
            }
        }

        // TODO: 변경된 내용을 파일에 다시 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedWriter를 사용하여 수정된 내용 쓰기
        // 3. 변경된 라인 수 출력
        // 4. 예외 처리

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for(String line : text) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("총 " + replaceCount + "개의 줄이 변경됨");
        } catch (IOException e) {
            System.out.println("파일 작성 중 오류 발생");
            System.out.println(e.getMessage());

            return;
        }
    }

    /**
     * 파일 통계 계산 (라인 수, 단어 수, 문자 수)
     */
    private static void countFileStats() {
        // TODO: "파일 통계 계산하기" 타이틀을 출력하세요.
        System.out.println("파일 통계 계산하기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        if(!file.exists()) {
            System.out.println("파일이 존재하지 않습니다\n");

            return;
        }

        // TODO: 파일 통계를 계산하세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedReader를 사용하여 파일 읽기
        // 3. 라인 수 계산 (반복문에서 라인 카운트 증가)
        // 4. 단어 수 계산 (각 라인을 공백으로 분할하여 단어 카운트)
        // 5. 문자 수 계산 (각 라인의 길이 합산)
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류 발생");
            System.out.println(e.getMessage());
        }

        // TODO: 계산된 통계 정보를 출력하세요.
        // 1. 라인 수
        // 2. 단어 수
        // 3. 문자 수
        // 4. 예외 처리
        System.out.println("줄 수 : " + lineCount);
        System.out.println("단어 수 : " + wordCount);
        System.out.println("문자 수 : " + charCount);
    }

    /**
     * 파일에 내용 추가
     */
    private static void appendToFile(Scanner scanner) {
        // TODO: "파일에 내용 추가하기" 타이틀을 출력하세요.
        System.out.println("파일에 내용 추가하기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        if(!file.exists()) {
            System.out.println("파일이 존재하지 않습니다\n");

            return;
        }

        // TODO: 사용자로부터 추가할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장
        List<String> append = new ArrayList<>();
        int lineCount = 0;

        while(true) {
            String line = scanner.nextLine();

            if(line.equals("")) {
                break;
            }

            line = ++lineCount + ". " + line;
            append.add(line);
        }

        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 추가하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter(파일경로, true)를 사용하여 append 모드로 열기
        // 3. 구분선("--- 추가된 내용 ---") 추가
        // 4. 리스트의 각 줄을 파일에 추가
        // 5. 예외 처리 및 성공 메시지 출력
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("--- 추가된 내용 ---");
            
            for(String line : append) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("파일 작성 중 오류 발생");
            System.out.println(e.getMessage());

            return;
        }

        System.out.println("파일 내용 추가 완료");
    }
}