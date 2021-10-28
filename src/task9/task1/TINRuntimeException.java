package task9.task1;

/**
 * Taxpayer Identification Number (TIN)
 * Exception is thrown if TIN is invalid
 */
public class TINRuntimeException extends RuntimeException{
    public TINRuntimeException(String message) {
        super(message);
    }
}
