import java.util.Random;

/**
 * Сравнение двух алгоритмов сортировки:
 * Bubble Sort и Quick Sort
 */
public class Main {

    public static void main(String[] args) {

        int smallSize = 1000;
        int largeSize = 100000;

        int[] smallArray1 = generateArray(smallSize);
        int[] smallArray2 = smallArray1.clone();

        int[] largeArray1 = generateArray(largeSize);
        int[] largeArray2 = largeArray1.clone();

        // --- Маленький массив ---
        System.out.println("МАЛЕНЬКИЙ МАССИВ:");

        long start = System.nanoTime();
        bubbleSort(smallArray1);
        long end = System.nanoTime();
        System.out.println("Bubble Sort: " + (end - start) + " ns");

        start = System.nanoTime();
        quickSort(smallArray2, 0, smallArray2.length - 1);
        end = System.nanoTime();
        System.out.println("Quick Sort: " + (end - start) + " ns");

        // --- Большой массив ---
        System.out.println("\nБОЛЬШОЙ МАССИВ:");

        start = System.nanoTime();
        bubbleSort(largeArray1);
        end = System.nanoTime();
        System.out.println("Bubble Sort: " + (end - start) + " ns");

        start = System.nanoTime();
        quickSort(largeArray2, 0, largeArray2.length - 1);
        end = System.nanoTime();
        System.out.println("Quick Sort: " + (end - start) + " ns");
    }

    /**
     * Генерация массива случайных чисел
     */
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }

        return arr;
    }

    /**
     * Пузырьковая сортировка
     * Сравниваем соседние элементы и меняем местами
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // обмен элементов
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Быстрая сортировка (Quick Sort)
     */
    public static void quickSort(int[] arr, int left, int right) {

        if (left >= right) return;

        int pivot = arr[(left + right) / 2];
        int i = left;
        int j = right;

        // Разделение массива
        while (i <= j) {

            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // Рекурсивно сортируем части
        quickSort(arr, left, j);
        quickSort(arr, i, right);
    }
}