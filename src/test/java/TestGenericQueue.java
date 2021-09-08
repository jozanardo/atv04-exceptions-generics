import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for GenericQueue.
 */
@DisplayName("Tests for Queue")
public class TestGenericQueue {

    private static final int defaultCapacity = 10;
    protected Queue<Integer> defaultGenericQueue;

    @BeforeEach
    public void setUpDefaults() {
        defaultGenericQueue = new GenericQueue<>(defaultCapacity);
    }

    @Test
    public void testInvalidCapacity() {
        final var exception = IllegalArgumentException.class;

        Assertions.assertThrows(exception, () -> new GenericQueue<Integer>(-10),
            String.format("Should throw %s with a negative capacity value", exception.getName()));
    }

    @Test
    public void testNullQueueIsEmpty() {
        var queue = new GenericQueue<Integer>(0);

        Assertions.assertTrue(queue.isEmpty(), "Queue with capacity 0 should "
            + "always be empty");
    }

    @Test
    public void testIsEmpty() {
        final var v = TestUtil.randomIntArray();

        Assertions.assertTrue(defaultGenericQueue.isEmpty(), "Newly created queue should be empty");
        for (var e : v) {
            try {
                defaultGenericQueue.enqueue(e);
            } catch (QueueFullException queueFullException) {
                unexpectedQueueFullException();
            }
            Assertions.assertFalse(defaultGenericQueue.isEmpty(), "Queue should not be empty "
                + "with size " + defaultGenericQueue.size());
        }

        for (int i = 0; i < v.length; i++) {
            Assertions.assertFalse(defaultGenericQueue.isEmpty(), "Queue should not be empty "
                + "with size " + defaultGenericQueue.size());
            try {
                defaultGenericQueue.dequeue();
            } catch (QueueEmptyException e) {
                unexpectedQueueEmptyException();
            }
        }
        Assertions.assertTrue(defaultGenericQueue.isEmpty(), "Queue should be empty with "
            + "size " + defaultGenericQueue.size());
    }

    @Test
    public void testNullQueueIsFull() {
        var queue = new GenericQueue<Integer>(0);

        Assertions.assertTrue(queue.isFull(), "Queue with capacity 0 should "
            + "always be full");
    }

    @Test
    public void testIsFull() {
        final var v = TestUtil.randomIntArray();

        for (var e : v) {
            Assertions.assertFalse(defaultGenericQueue.isFull(), "Queue should not be full "
                + "with size: " + defaultGenericQueue.size());
            try {
                defaultGenericQueue.enqueue(e);
            } catch (QueueFullException queueFullException) {
                unexpectedQueueFullException();
            }
        }
        Assertions.assertTrue(defaultGenericQueue.isFull(), "Queue should be full "
            + "with size: " + defaultGenericQueue.size());
    }

    @Test
    public void testFullQueueOnEnqueue() {
        final var exception = QueueFullException.class;
        final var v = TestUtil.randomIntArray();

        for (int e : v) {
            try {
                defaultGenericQueue.enqueue(e);
            } catch (QueueFullException queueFullException) {
                unexpectedQueueFullException();
            }
        }
        Assertions.assertThrows(exception, () -> defaultGenericQueue.enqueue(100),
            String.format("Should throw %s when enqueuing on full queue", exception.getName()));
    }

    @Test
    public void testEnqueue() {
        final var v = TestUtil.randomIntArray();

        for (int i = 0; i < v.length; i++) {
            try {
                defaultGenericQueue.enqueue(v[i]);
            } catch (QueueFullException e) {
                unexpectedQueueFullException();
            }
            try {
                Assertions.assertEquals(v[0], defaultGenericQueue.front(),
                    "Queue front does not match expected value");
                Assertions.assertEquals(v[i], defaultGenericQueue.rear(),
                    "Queue rear does not match expected value");
            } catch (QueueEmptyException e) {
                unexpectedQueueEmptyException();
            }
            Assertions.assertEquals(i + 1, defaultGenericQueue.size(),
                "Queue size does match expected value");
        }
        Assertions.assertTrue(defaultGenericQueue.isFull(),
            "Queue should be full when size reaches capacity");
    }

    @Test
    public void testDequeue() {
        final var v = TestUtil.randomIntArray();

        for (var e : v) {
            try {
                defaultGenericQueue.enqueue(e);
            } catch (QueueFullException queueFullException) {
                unexpectedQueueFullException();
            }
        }

        for (int i = 0; i < v.length; i++) {

            try {
                Assertions.assertEquals(v[v.length - 1], defaultGenericQueue.rear(),
                    "Queue rear does not match expected value");
                Assertions.assertEquals(defaultGenericQueue.dequeue(), v[i],
                    "Dequeue operation is not returning expected value");
            } catch (QueueEmptyException e) {
                unexpectedQueueEmptyException();
            }
            Assertions.assertEquals(v.length - 1 - i, defaultGenericQueue.size(),
                "Queue size does match expected value");
        }
        Assertions.assertEquals(0, defaultGenericQueue.size(),
            "Queue should be empty after dequeing all elements");
    }

    @Test
    public void testClear() {
        try {
            defaultGenericQueue.enqueue(10);
        } catch (QueueFullException e) {
            unexpectedQueueFullException();
        }
        Assertions.assertFalse(defaultGenericQueue.isEmpty(),
            "Queue should not be empty after one push");
        defaultGenericQueue.clear();
        Assertions.assertTrue(defaultGenericQueue.isEmpty(),
            "Queue should be empty after clear");
    }

    @Test
    public void testStringQueue() {
        var queue = new GenericQueue<String>(TestUtil.stringArray.length);

        for (var s : TestUtil.stringArray) {
            try {
                queue.enqueue(s);
            } catch (QueueFullException e) {
                unexpectedQueueFullException();
            }

            try {
                Assertions.assertEquals(queue.rear(), s,
                    "Queue rear value does match expected value");
                Assertions.assertEquals(queue.front(), TestUtil.stringArray[0],
                    "Queue front value does match expected value");
            } catch (QueueEmptyException e) {
                unexpectedQueueEmptyException();
            }
        }

        for (int i = 0; i < TestUtil.stringArray.length; i++) {
            try {
                Assertions.assertEquals(queue.dequeue(),
                    TestUtil.stringArray[i],
                    "Queue dequeued value does not match expected value");
            } catch (QueueEmptyException e) {
                unexpectedQueueEmptyException();
            }
        }
    }

    private void unexpectedQueueException(String type) {
        Assertions.fail(
            String.format("Should not throw exception on non-%s stack. Size: %d. Capacity: %d",
                type, defaultGenericQueue.size(), defaultGenericQueue.capacity()));
    }

    private void unexpectedQueueFullException() {
        unexpectedQueueException("full");
    }

    private void unexpectedQueueEmptyException() {
        unexpectedQueueException("empty");
    }

}
