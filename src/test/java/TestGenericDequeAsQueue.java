import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * Tests a Deque as a Queue.
 */
@DisplayName("Tests for Deque as a Queue")
public class TestGenericDequeAsQueue extends TestGenericQueue {

    @Override
    @BeforeEach
    public void setUpDefaults() {
        defaultGenericQueue = new GenericDeque<>(TestUtil.defaultSize);
    }
}
