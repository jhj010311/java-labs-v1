package chapter6.labs.lab2;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * Lab 2: 파일 입출력과 예외처리
 * 
 * 텍스트 파일을 읽고 내용을 분석하는 프로그램입니다.
 * 파일 입출력 작업에서 발생할 수 있는 다양한 예외를 처리해야 합니다.
 */
public class FileIOExceptionLab {
    public static void main(String[] args) throws IOException {
        System.out.println("Lab 2: 파일 입출력과 예외처리 실습");

        Scanner scanner = new Scanner(System.in);

        // TODO: 사용자로부터 읽을 파일 이름을 입력받으세요.
        System.out.println("파일 이름 입력 : ");
        String fileName = scanner.nextLine();


        // TODO: try-with-resources 구문을 사용하여 파일을 읽고 내용을 분석하세요.
        // 1. BufferedReader를 사용하여 파일을 한 줄씩 읽습니다.
        // 2. 각 줄의 길이와 단어 수를 계산합니다.
        // 3. 파일의 전체 줄 수, 단어 수, 문자 수를 출력합니다.
        // 4. 다음 예외 상황을 처리하세요:
        //    - FileNotFoundException: 파일이 존재하지 않는 경우
        //    - IOException: 파일 읽기 중 오류가 발생한 경우
        //    - 기타 예외: 기타 모든 예외 상황
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("chapter6/labs/lab2/" + fileName + ".txt"));

            String line;
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            while ((line = bufferedReader.readLine()) != null) {
                lineCount++;
                System.out.println("\n현재 " + lineCount + "번째 줄");
                System.out.println("현재 줄 길이 : " + line.length());

                if(line.length() == 0){
                    System.out.println("현재 줄 단어 수 : 0");
                } else {
                    String[] words = line.split("\\s+");
                    System.out.println("현재 줄 단어 수 : " + words.length);
                    wordCount += words.length;

                    for (String word : words) {
                        charCount += word.length();
                    }
                }
            }

            System.out.println("\n전체 줄 수 : " + lineCount);
            System.out.println("전체 단어 수 : " + wordCount);
            System.out.println("공백 미포함 문자수 : " + charCount);
        } catch (FileNotFoundException e) {
            System.out.println("해당하는 파일을 찾을 수 없습니다");
            e.getMessage();
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다");
            e.getMessage();
        } catch (Exception e) {
            System.out.println("기타 에러");
            e.getMessage();
        }


        // 참고: 단어 수 계산을 위해 String.split("\\s+") 메소드를 활용할 수 있습니다.


        scanner.close();
        System.out.println("\n프로그램을 종료합니다.");
    }
} 