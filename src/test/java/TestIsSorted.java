import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for isSorted() static method.
 */
@DisplayName("Tests for ArrayUtils.isSorted")
public class TestIsSorted {
    @Test
    public void testUnsortedInts() {
        try (var scanner = new Scanner(new File(TestUtil.unsortedIntFile))) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                Integer[] v = new Integer[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.nextInt();
                }

                Assertions.assertFalse(ArraysUtil.isSorted(v),
                    "Array is not sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted ints case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testSortedInts() {
        try (var scanner = new Scanner(new File(TestUtil.sortedIntFile))) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                Integer[] v = new Integer[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.nextInt();
                }

                Assertions.assertTrue(ArraysUtil.isSorted(v),
                    "Array is sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted ints case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testUnsortedDoubles() {
        try (var scanner = new Scanner(new File(TestUtil.unsortedDoubleFile),
            StandardCharsets.UTF_8)) {
            scanner.useLocale(Locale.US);
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                Double[] v = new Double[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.nextDouble();
                }

                Assertions.assertFalse(ArraysUtil.isSorted(v),
                    "Array is not sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted doubles case file");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Failed to open unsorted double file in UTF-8 charset");
            e.printStackTrace();
        }
    }

    @Test
    public void testSortedDoubles() {
        try (var scanner = new Scanner(new File(TestUtil.sortedDoubleFile),
            StandardCharsets.UTF_8)) {
            scanner.useLocale(Locale.US);
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                Double[] v = new Double[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.nextDouble();
                }

                Assertions.assertTrue(ArraysUtil.isSorted(v),
                    "Array is sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted ints case file");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Failed to open sorted double file in UTF-8 charset");
            e.printStackTrace();
        }
    }

    @Test
    public void testUnsortedStrings() {
        try (var scanner = new Scanner(new File(TestUtil.unsortedShakespeareFile),
            StandardCharsets.UTF_8)) {
            scanner.useLocale(Locale.US);
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                String[] v = new String[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.next();
                }

                Assertions.assertFalse(ArraysUtil.isSorted(v),
                    "Array is not sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted doubles case file");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Failed to open unsorted string file in UTF-8 charset");
            e.printStackTrace();
        }
    }

    @Test
    public void testSortedStrings() {
        try (var scanner = new Scanner(new File(TestUtil.sortedShakespeareFile),
            StandardCharsets.UTF_8)) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                String[] v = new String[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.next();
                }

                Assertions.assertTrue(ArraysUtil.isSorted(v),
                    "Array is sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted ints case file");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Failed to open sorted string file in UTF-8 charset");
            e.printStackTrace();
        }
    }
}
