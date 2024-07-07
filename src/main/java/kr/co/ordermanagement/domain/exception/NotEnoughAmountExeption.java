package kr.co.ordermanagement.domain.exception;

public class NotEnoughAmountExeption extends RuntimeException{
    public NotEnoughAmountExeption(String message) {
        super(message);
    }
}
