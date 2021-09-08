/**
 * Exception to be thrown when a stack is empty.
 */
public class StackEmptyException extends Exception {

    public StackEmptyException(String message) {
        super(message);
    }

    public StackEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
