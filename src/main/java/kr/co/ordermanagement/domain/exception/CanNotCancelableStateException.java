package kr.co.ordermanagement.domain.exception;

public class CanNotCancelableStateException extends RuntimeException {
    public CanNotCancelableStateException(String message) {
        super(message);
    }
}
