package pl.arturzaczek.testing2.exception;

public class NoActiveProductException extends RuntimeException{
    public NoActiveProductException() {
    }

    public NoActiveProductException(String message) {
        super(message);
    }
}
