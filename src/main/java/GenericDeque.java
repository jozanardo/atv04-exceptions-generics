/**
 * Um Deque generico associado ao GenericLinkedList.
 *
 * @param <T> o tipo genérico
 */
public class GenericDeque<T> implements Queue<T>, Stack<T> {
    private final GenericLinkedList<T> elements;
    private final int capacidade;

    /**
     * Construtor para um Deque generico.
     *
     * @param size capacidade do deque
     */
    public GenericDeque(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be greater than or equal to 0");
        }
        elements =  new GenericLinkedList<>();
        capacidade = size;
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

    @Override
    public void enqueue(T value) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Queue is full");
        }
        elements.addLast(value);
    }

    /**
     * Dequeue (remove) the first element.
     *
     * @return the first element.
     * @throws QueueEmptyException when queue has no elements
     */
    @Override
    public T dequeue() throws QueueEmptyException {
        try {
            if (isEmpty()) {
                throw new ListEmptyException("Cannot remove values");
            }
            return elements.removeFirst();
        } catch (ListEmptyException e) {
            throw new QueueEmptyException(e.getMessage(), e);
        }
    }

    /**
     * Query (without removing) the first element.
     *
     * @return the first element.
     * @throws QueueEmptyException when queue has no elements
     */
    @Override
    public T front() throws QueueEmptyException {
        try {
            return elements.peekFirst();
        } catch (ListEmptyException e) {
            throw new QueueEmptyException(e.getMessage(), e);
        }
    }

    /**
     * Query (without removing) the last element.
     *
     * @return the last element.
     * @throws QueueEmptyException when queue has no elements
     */
    @Override
    public T rear() throws QueueEmptyException {
        try {
            return elements.peekLast();
        } catch (ListEmptyException e) {
            throw new QueueEmptyException(e.getMessage(), e);
        }
    }

    /**
     * Remove all elements from the queue.
     */
    @Override
    public void clear() {
        elements.clear();
    }

}