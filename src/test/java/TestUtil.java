import java.util.Random;

/**
 * Utilities common to most tests.
 */
public final class TestUtil {

    public static final int defaultSize = 10;
    private static final int upperBound = 100;
    private static final Random random = new Random();

    public static final String unsortedIntFile = "src/test/resources/unsorted-int.txt";
    public static final String unsortedDoubleFile = "src/test/resources/unsorted-double.txt";
    public static final String sortedIntFile = "src/test/resources/sorted-int.txt";
    public static final String sortedDoubleFile = "src/test/resources/sorted-double.txt";
    public static final String unsortedShakespeareFile =
        "src/test/resources/unsorted-shakespeare.txt";
    public static final String sortedShakespeareFile =
        "src/test/resources/sorted-shakespeare.txt";

    public static final String[] stringArray = new String[]{
        "Lorem",
        "ipsum",
        "dolor",
        "sit",
        "amet,",
        "consectetur",
        "adipiscing",
        "elit.",
        "Sed",
        "quis",
        "faucibus",
        "lacus.",
        "Morbi",
        "odio",
        "eros,",
        "tincidunt",
        "eget",
        "cursus",
        "eu,",
        "pretium",
        "nec",
        "purus"
    };

    private TestUtil() {}

    /**
     * Generate a random array with default size.
     *
     * @return the generated array
     */
    public static int[] randomIntArray() {
        int[] v = new int[defaultSize];

        for (int i = 0; i < defaultSize; i++) {
            v[i] = random.nextInt(upperBound);
        }

        return v;
    }
}
