package chapter6.examples.ex4;

public class CustomRuntimeException extends RuntimeException {

    private int errorCode;

    public CustomRuntimeException() {
        super("사용자 정의 예외가 발생했습니다.");
        this.errorCode = 0;
    }
}
