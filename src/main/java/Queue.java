/**
 * Interface for structures implementing FIFO logic.
 *
 * @param <T> the generic type
 */
public interface Queue<T> {
    /**
     * Whether the queue is full.
     *
     * @return true if it is full, false otherwise
     */
    boolean isFull();

    /**
     * Whether the queue is empty.
     *
     * @return true if it is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * The size of the queue.
     *
     * @return the size
     */
    int size();

    /**
     * The capacity of the queue.
     *
     * @return the capacity
     */
    int capacity();

    /**
     * Enqueue a new element.
     *
     * @param value the value to enqueue
     * @throws QueueFullException when queue reached its capacity
     */
    void enqueue(T value) throws QueueFullException;

    /**
     * Dequeue (remove) the first element.
     *
     * @return the first element.
     * @throws QueueEmptyException when queue has no elements
     */
    T dequeue() throws QueueEmptyException;

    /**
     * Query (without removing) the first element.
     *
     * @return the first element.
     * @throws QueueEmptyException when queue has no elements
     */
    T front() throws QueueEmptyException;

    /**
     * Query (without removing) the last element.
     *
     * @return the last element.
     * @throws QueueEmptyException when queue has no elements
     */
    T rear() throws QueueEmptyException;

    /**
     * Remove all elements from the queue.
     */
    void clear();

    /**
     * Generate a string representation of the queue.
     *
     * @return the string representation.
     */
    @Override
    String toString();
}