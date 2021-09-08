import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * Tests a Deque as a Stack.
 */
@DisplayName("Tests for Deque as a Stack")
public class TestGenericDequeAsStack extends TestGenericStack {

    @Override
    @BeforeEach
    public void setUpDefaults() {
        defaultGenericStack = new GenericDeque<>(TestUtil.defaultSize);
    }
}
