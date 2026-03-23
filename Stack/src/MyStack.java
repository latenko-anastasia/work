/**
 * Класс MyStack реализует стек (LIFO) на основе массива.
 * Добавление и удаление происходит с вершины.
 */
public class MyStack<T> {

    private T[] data;     // хранилище элементов
    private int top;      // индекс вершины

    /**
     * Инициализация стека заданного размера
     */
    @SuppressWarnings("unchecked")
    public MyStack(int maxSize) {
        data = (T[]) new Object[maxSize];
        top = -1; // стек изначально пуст
    }

    /**
     * Добавление элемента в стек
     */
    public void push(T element) {
        // Проверяем, есть ли место для нового элемента
        if (top == data.length - 1) {
            System.out.println("Нет места в стеке");
            return;
        }

        data[++top] = element;
    }

    /**
     * Извлечение элемента с вершины
     */
    public T pop() {
        // Если стек пуст — возвращаем null
        if (isEmpty()) {
            System.out.println("Стек пустой");
            return null;
        }

        T value = data[top];
        data[top--] = null; // очищаем ссылку
        return value;
    }

    /**
     * Просмотр верхнего элемента
     */
    public T peek() {
        if (isEmpty()) {
            System.out.println("Стек пустой");
            return null;
        }

        return data[top];
    }

    /**
     * Проверка пустоты стека
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Вывод содержимого стека
     */
    public void show() {
        System.out.println("Содержимое стека:");

        // Перебор элементов от низа к вершине
        for (int i = 0; i <= top; i++) {
            System.out.println(data[i]);
        }
    }
}