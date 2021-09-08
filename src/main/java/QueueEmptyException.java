/**
 * Exception to br thrown when a queue is empty.
 */
public class QueueEmptyException extends Exception {
    public QueueEmptyException(String message) {
        super(message);
    }

    public QueueEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
