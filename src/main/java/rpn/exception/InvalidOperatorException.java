package rpn.exception;

public class InvalidOperatorException extends RuntimeException {
    private String operator;

    public InvalidOperatorException(String operator) {
        this.operator = operator;
    }
}
