/**
 * Класс MyQueue реализует очередь (FIFO) на основе массива.
 * Элементы добавляются в конец и удаляются из начала.
 */
public class MyQueue<T> {

    private T[] data;   // массив для хранения
    private int head;   // начало очереди
    private int tail;   // конец очереди
    private int count;  // количество элементов

    /**
     * Создание очереди фиксированного размера
     */
    @SuppressWarnings("unchecked")
    public MyQueue(int size) {
        data = (T[]) new Object[size];
        head = 0;
        tail = 0;
        count = 0;
    }

    /**
     * Добавление элемента
     */
    public void add(T value) {
        // Проверка заполненности
        if (count == data.length) {
            System.out.println("Очередь заполнена");
            return;
        }

        data[tail] = value;

        // Сдвиг указателя с циклическим переходом
        tail = (tail + 1) % data.length;
        count++;
    }

    /**
     * Удаление элемента
     */
    public T remove() {
        // Проверка пустоты
        if (count == 0) {
            System.out.println("Очередь пустая");
            return null;
        }

        T temp = data[head];
        data[head] = null;

        // Сдвигаем начало очереди
        head = (head + 1) % data.length;
        count--;

        return temp;
    }

    /**
     * Просмотр первого элемента
     */
    public T front() {
        if (count == 0) {
            System.out.println("Очередь пустая");
            return null;
        }

        return data[head];
    }

    /**
     * Проверка на пустоту
     */
    public boolean empty() {
        return count == 0;
    }

    /**
     * Вывод элементов очереди
     */
    public void showQueue() {
        System.out.println("Очередь содержит:");

        // Перебираем элементы с учётом цикличности
        for (int i = 0; i < count; i++) {
            int index = (head + i) % data.length;
            System.out.println(data[index]);
        }
    }
}