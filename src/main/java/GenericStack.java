/**
 * Uma Stack generica associada ao GenericLinkedList.
 *
 * @param <T> o tipo genérico
 */
public class GenericStack<T> implements Stack<T> {
    private final GenericLinkedList<T> elements;
    private final int capacidade;

    /**
     * Construtor para uma Stack generica.
     *
     * @param size capacidade da Stack
     */
    public GenericStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be greater than or equal to 0");
        }
        elements =  new GenericLinkedList<>();
        capacidade = size;
    }

    /**
     * The size of the queue.
     *
     * @return the size
     */
    @Override
    public int size() {
        return elements.size();
    }

    /**
     * The capacity of the queue.
     *
     * @return the capacity
     */
    @Override
    public int capacity() {
        return capacidade;
    }

    /**
     * Push a new value to the stack.
     *
     * @param value the value
     * @throws StackFullException when stack reached its capacity
     */
    @Override
    public void push(T value) throws StackFullException {

        if (isFull()) {
            throw new StackFullException("Cannot push the element");
        }
        elements.addLast(value);
    }

    /**
     * Pop a value from the stack.
     *
     * @return the value removed.
     * @throws StackEmptyException when stack has no element
     */
    @Override
    public T pop() throws StackEmptyException {
        try {
            return elements.removeLast();
        } catch (ListEmptyException e) {
            throw new StackEmptyException(e.getMessage(), e);
        }
    }

    /**
     * Query (without removing) the top value.
     *
     * @return the top value.
     * @throws StackEmptyException when stack has no element
     */
    @Override
    public T peek() throws StackEmptyException {
        try {
            return elements.peekLast();
        } catch (ListEmptyException e) {
            throw new StackEmptyException(e.getMessage(), e);
        }
    }

    /**
     * Remove all elements from the queue.
     */
    @Override
    public void clear() {
        elements.clear();
    }

    /**
     * Whether the queue is full.
     *
     * @return true if it is full, false otherwise
     */
    @Override
    public boolean isFull() {
        return elements.size() == capacity();
    }

    /**
     * Whether the queue is empty.
     *
     * @return true if it is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

}
