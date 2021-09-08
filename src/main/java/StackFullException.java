/**
 * Exception to be thrown when a stack is full.
 */
public class StackFullException extends Exception {

    public StackFullException(String message) {
        super(message);
    }

    public StackFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
