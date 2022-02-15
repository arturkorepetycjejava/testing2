package pl.arturzaczek.testing2.exception;

public class AccessTokenException extends RuntimeException{
    public AccessTokenException() {
    }

    public AccessTokenException(String message) {
        super(message);
    }

    public AccessTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
