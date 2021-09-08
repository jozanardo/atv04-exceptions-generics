/**
 * Uma Queue generica associada ao GenericLinkedList.
 *
 * @param <T> o tipo genérico
 */
public class GenericQueue<T> implements Queue<T> {
    private final GenericLinkedList<T> elements;
    private final int capacidade;

    /**
     * Construtor para uma queue generica.
     *
     * @param size capacidade da queue
     */
    public GenericQueue(int size) {
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
     * Enqueue a new element.
     *
     * @param value the value to enqueue
     * @throws QueueFullException when queue reached its capacity
     */
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
