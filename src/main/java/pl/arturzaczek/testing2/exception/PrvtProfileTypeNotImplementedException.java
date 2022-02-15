package pl.arturzaczek.testing2.exception;

public class PrvtProfileTypeNotImplementedException extends RuntimeException{
    public PrvtProfileTypeNotImplementedException() {
    }

    public PrvtProfileTypeNotImplementedException(String message) {
        super(message);
    }
}
