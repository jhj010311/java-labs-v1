import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 디버깅 실습 4: 예외 처리와 로깅
 * 
 * 이 코드에는 예외 처리가 제대로 되어 있지 않습니다.
 * 디버깅 도구와 예외 처리 기법을 활용하여 문제를 해결하세요.
 */
public class DebugginExercise4 {
    public static void main(String[] args) {
        System.out.println("디버깅 실습 4: 예외 처리와 로깅");
        
        // 과제 1: 파일 읽기 코드의 예외 처리 개선
        List<String> lines = readFile("data.txt");
        System.out.println("파일에서 읽은 라인 수: " + lines.size());
        
        // 과제 2: 배열 인덱스 예외 처리
        processArray();
        
        // 과제 3: 숫자 변환 예외 처리
        processNumbers();
        
        // 과제 4: 사용자 정의 예외 처리
        try {
            validateInput("123");
            validateInput("");
            validateInput(null);
        } catch (Exception e) {
            System.out.println("입력 검증 중 오류 발생: " + e.getMessage());
        }
    }
    
    /**
     * 파일을 읽는 메서드 (예외 처리 부족)
     */
    private static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = null;
        
        // 예외 처리가 부족한 코드 - 개선해야 함
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            
            // 파일을 닫는 코드가 없음
            
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
            // 로깅 코드가 없음
        }
        
        return lines;
    }
    
    /**
     * 배열 처리 메서드 (예외 처리 부족)
     */
    private static void processArray() {
        int[] numbers = {1, 2, 3, 4, 5};
        
        try {
            // 배열 범위를 벗어나는 접근
            for (int i = 0; i <= numbers.length; i++) {
                System.out.println("numbers[" + i + "] = " + numbers[i]);
            }
        } catch (Exception e) {
            // 너무 일반적인 예외 처리
            System.out.println("오류 발생: " + e.getMessage());
        }
    }
    
    /**
     * 숫자 변환 메서드 (예외 처리 부족)
     */
    private static void processNumbers() {
        String[] values = {"10", "20", "30", "40", "not a number", "50"};
        
        // 예외 처리가 없는 코드
        for (String value : values) {
            int number = Integer.parseInt(value);
            System.out.println("변환된 숫자: " + number);
        }
    }
    
    /**
     * 입력 검증 메서드 (사용자 정의 예외 처리 부족)
     */
    private static void validateInput(String input) throws Exception {
        // 적절한 사용자 정의 예외를 사용하지 않음
        if (input == null) {
            throw new Exception("입력값이 null입니다.");
        }
        
        if (input.isEmpty()) {
            throw new Exception("입력값이 비어 있습니다.");
        }
        
        System.out.println("입력값 검증 완료: " + input);
    }
} 