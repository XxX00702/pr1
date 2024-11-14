import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationsTest {

    @Test
    void testFindMaxModulusElementIndex() {
        int[] array = {1, -2, 3, -4, 5};
        int result = ArrayOperations.findMaxModulusElementIndex(array);
        assertEquals(4, result);  // Максимальний за модулем елемент - 5, його індекс 4
    }

    @Test
    void testProductAfterFirstPositive() {
        int[] array = {1, -2, 3, -4, 5};
        int result = ArrayOperations.productAfterFirstPositive(array);
        assertEquals(-20, result);  // Після першого додатного елемента (3) добуток -4 * 5 = -20
    }


    @Test
    void testProductAfterFirstPositive_NoPositive() {
        int[] array = {-1, -2, -3};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ArrayOperations.productAfterFirstPositive(array);
        });
        assertEquals("У масиві немає додатних елементів.", exception.getMessage());
    }

    @Test
    void testFindMaxModulusElementIndex_EmptyArray() {
        int[] array = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ArrayOperations.findMaxModulusElementIndex(array);
        });
        assertEquals("Масив не може бути порожнім.", exception.getMessage());
    }
}
