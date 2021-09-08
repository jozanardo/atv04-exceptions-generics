import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for GenericStack.
 */
@DisplayName("Tests for Stack")
public class TestGenericStack {

    protected Stack<Integer> defaultGenericStack;

    @BeforeEach
    public void setUpDefaults() {
        defaultGenericStack = new GenericStack<>(TestUtil.defaultSize);
    }

    @Test
    public void testExceptionOnInvalidCapacity() {
        final var exception = IllegalArgumentException.class;
        Assertions.assertThrows(exception, () -> new GenericStack<Integer>(-10),
            String.format("Constructor should throw %s on negative capacity", exception.getName()));
    }

    @Test
    public void testNullStackIsFull() {
        var stack = new GenericStack<Integer>(0);

        Assertions.assertTrue(stack.isFull(),
            "Stack with capacity 0 should always be full");
    }

    @Test
    public void testStackIsFull() {
        var v = TestUtil.randomIntArray();

        for (int e : v) {
            Assertions.assertFalse(defaultGenericStack.isFull(),
                "Stack should not be full with size " + TestUtil.defaultSize);
            try {
                defaultGenericStack.push(e);
            } catch (StackFullException stackFullException) {
                unexpectedStackFullException();
            }
        }
        Assertions.assertTrue(defaultGenericStack.isFull(),
            "Stack should be full with size " + defaultGenericStack.size());
    }

    @Test
    public void testNullStackIsEmpty() {
        var stack = new GenericStack<Integer>(0);

        Assertions.assertTrue(stack.isEmpty(),
            "Stack with capacity 0 should always be empty");
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(defaultGenericStack.isEmpty(),
            "Newly created stack should be empty");

        var v = TestUtil.randomIntArray();

        for (int e : v) {
            try {
                defaultGenericStack.push(e);
            } catch (StackFullException stackFullException) {
                unexpectedStackFullException();
            }
            Assertions.assertFalse(defaultGenericStack.isEmpty(),
                "Stack should not be empty with size " + defaultGenericStack.size());
        }
        for (int i = 0; i < TestUtil.defaultSize; i++) {
            Assertions.assertFalse(defaultGenericStack.isEmpty(),
                "Stack should not be empty with size " + defaultGenericStack.size());
            try {
                defaultGenericStack.pop();
            } catch (StackEmptyException e) {
                unexpectedStackEmptyException();
            }
        }
        Assertions.assertTrue(defaultGenericStack.isEmpty(),
            "Stack should be empty after popping all elements.");
    }

    @Test
    public void testFullExceptionOnPush() {
        final var exception = StackFullException.class;

        Assertions.assertThrows(exception, () -> {
            for (int i = 0; i < TestUtil.defaultSize; i++) {
                defaultGenericStack.push(i);
            }
            defaultGenericStack.push(TestUtil.defaultSize);
        }, "Should throw exception when pushing on full stack");
    }

    @Test
    public void testPushPeek() {
        final var sizeMessage = "Stack does not match expected size";
        final var topMessage = "Stack top value does not match expected value";
        final var v = TestUtil.randomIntArray();

        Assertions.assertEquals(0, defaultGenericStack.size(), sizeMessage);
        for (int i = 0; i < v.length; i++) {
            try {
                defaultGenericStack.push(v[i]);
            } catch (StackFullException e) {
                unexpectedStackFullException();
            }
            Assertions.assertEquals(i + 1, defaultGenericStack.size(), sizeMessage);
            try {
                Assertions.assertEquals(v[i], defaultGenericStack.peek(), topMessage);
            } catch (StackEmptyException e) {
                unexpectedStackEmptyException();
            }
        }
    }

    @Test
    public void testEmptyExceptionOnPop() {
        final var exception = StackEmptyException.class;

        Assertions.assertThrows(exception, () -> defaultGenericStack.pop(),
            String.format("Should throw %s when popping empty stack", exception.getName()));
    }

    @Test
    public void testPop() {
        final var sizeMessage = "Stack size is out of expected value";
        int[] v = TestUtil.randomIntArray();

        for (int j : v) {
            try {
                defaultGenericStack.push(j);
            } catch (StackFullException e) {
                unexpectedStackFullException();
            }
        }

        Assertions.assertEquals(TestUtil.defaultSize, defaultGenericStack.size(), sizeMessage);
        for (int i = v.length - 1; i >= 0; i--) {
            int value = 0;

            try {
                value = defaultGenericStack.pop();
            } catch (StackEmptyException e) {
                unexpectedStackEmptyException();
            }

            Assertions.assertEquals(v[i], value, "Stack top does not match expected value");
            Assertions.assertEquals(i, defaultGenericStack.size());
        }
        Assertions.assertEquals(0, defaultGenericStack.size(), sizeMessage);
    }

    @Test
    public void testEmptyExceptionOnPeek() {
        final var exception = StackEmptyException.class;

        Assertions.assertThrows(exception, () -> defaultGenericStack.peek(),
            String.format("Should throw %s when peeking on empty stack", exception.getName()));
    }

    @Test
    public void testClear() {
        try {
            defaultGenericStack.push(10);
        } catch (StackFullException e) {
            unexpectedStackFullException();
        }
        Assertions.assertFalse(defaultGenericStack.isEmpty(),
            "Stack should not be empty after one push");
        defaultGenericStack.clear();
        Assertions.assertTrue(defaultGenericStack.isEmpty(),
            "Stack should be empty after clear");
    }

    @Test
    public void testStringStack() {
        var stack = new GenericStack<String>(TestUtil.stringArray.length);

        for (var s : TestUtil.stringArray) {
            try {
                stack.push(s);
            } catch (StackFullException e) {
                unexpectedStackFullException();
            }
            try {
                Assertions.assertEquals(stack.peek(), s,
                    "Stack top value does match expected value");
            } catch (StackEmptyException e) {
                unexpectedStackEmptyException();
            }
        }

        for (int i = 0; i < TestUtil.stringArray.length; i++) {
            try {
                Assertions.assertEquals(stack.pop(),
                    TestUtil.stringArray[TestUtil.stringArray.length - i - 1],
                    "Stack popped value does not match expected value");
            } catch (StackEmptyException e) {
                unexpectedStackEmptyException();
            }
        }
    }

    private void unexpectedStackException(String type) {
        Assertions.fail(
            String.format("Should not throw exception on non-%s stack. Size: %d. Capacity: %d",
                type, defaultGenericStack.size(), defaultGenericStack.capacity()));
    }

    private void unexpectedStackFullException() {
        unexpectedStackException("full");
    }

    private void unexpectedStackEmptyException() {
        unexpectedStackException("empty");
    }
}
