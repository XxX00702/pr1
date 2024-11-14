import java.util.Random;

public class ArrayOperations {

    // Метод для генерування масиву випадкових цілих чисел в діапазоні [-100, 100]
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100; // Генеруємо число в діапазоні [-100, 100]
        }
        return array;
    }

    // Метод для пошуку номера максимального елемента за модулем
    public static int findMaxModulusElementIndex(int[] array) throws IllegalArgumentException {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім.");
        }

        int maxModulus = 0;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i]) > maxModulus) {
                maxModulus = Math.abs(array[i]);
                index = i;
            }
        }
        return index;
    }

    // Метод для обчислення добутку елементів після першого додатного числа
    public static int productAfterFirstPositive(int[] array) throws IllegalArgumentException {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім.");
        }

        int product = 1;
        boolean foundPositive = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                foundPositive = true;
                // Після першого додатного числа обчислюємо добуток
                for (int j = i + 1; j < array.length; j++) {
                    product *= array[j];
                }
                break;
            }
        }

        if (!foundPositive) {
            throw new IllegalArgumentException("У масиві немає додатних елементів.");
        }

        return product;
    }

    public static void main(String[] args) {
        try {
            // Створюємо масив випадкових цілих чисел
            int[] array = generateRandomArray(10);

            // Виводимо масив
            System.out.println("Масив:");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Знаходимо номер максимального елемента за модулем
            int maxModulusIndex = findMaxModulusElementIndex(array);
            System.out.println("Номер максимального за модулем елемента: " + maxModulusIndex);

            // Обчислюємо добуток елементів після першого додатного числа
            int product = productAfterFirstPositive(array);
            System.out.println("Добуток елементів після першого додатного числа: " + product);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
