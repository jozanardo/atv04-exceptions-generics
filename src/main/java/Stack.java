/**
 * Interface for structures implementing LIFO logic.
 *
 * @param <T> the generic type
 */
public interface Stack<T> {

    /**
     * The size of the stack.
     *
     * @return the size
     */
    int size();

    /**
     * The capacity of the stack.
     *
     * @return the capacity
     */
    int capacity();

    /**
     * Push a new value to the stack.
     *
     * @param value the value
     * @throws StackFullException when stack reached its capacity
     */
    void push(T value) throws StackFullException;

    /**
     * Pop a value from the stack.
     *
     * @return the value removed.
     * @throws StackEmptyException when stack has no element
     */
    T pop() throws StackEmptyException;

    /**
     * Query (without removing) the top value.
     *
     * @return the top value.
     * @throws StackEmptyException when stack has no element
     */
    T peek() throws StackEmptyException;

    /**
     * Remove all elements from the stack.
     */
    void clear();

    /**
     * Whether the stack is full.
     *
     * @return true if it is full, false otherwise
     */
    boolean isFull();

    /**
     * Whether the stack is empty.
     *
     * @return true if it is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Generate a string representation of the stack.
     *
     * @return the string representation
     */
    @Override
    String toString();
}