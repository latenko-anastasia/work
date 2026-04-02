/**
 * Класс MySet реализует множество.
 * Хранит уникальные элементы (без повторений).
 */
public class MySet {

    private int[] data;  // массив для хранения
    private int size;    // текущее количество элементов

    /**
     * Конструктор
     */
    public MySet(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * Добавление элемента (если его ещё нет)
     */
    public void add(int value) {

        // Проверка: есть ли уже такой элемент
        if (contains(value)) {
            System.out.println("Элемент уже существует");
            return;
        }

        // Проверка переполнения
        if (size == data.length) {
            System.out.println("Нет места");
            return;
        }

        data[size++] = value;
    }

    /**
     * Удаление элемента
     */
    public void remove(int value) {

        for (int i = 0; i < size; i++) {

            if (data[i] == value) {

                // Сдвигаем элементы влево
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }

                size--;
                return;
            }
        }
    }

    /**
     * Проверка наличия элемента
     */
    public boolean contains(int value) {

        // Перебор всех элементов
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * Вывод множества
     */
    public void printSet() {

        System.out.print("Множество: ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }
}