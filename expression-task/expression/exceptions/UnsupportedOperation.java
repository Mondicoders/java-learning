package expression.exceptions;

public class UnsupportedOperation extends RuntimeException {

    // Missing operation: 2 --> <-- 2

    public UnsupportedOperation(String message) {
        super(message);
    }
}
