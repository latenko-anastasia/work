/**
 * Класс MyList реализует односвязный список.
 * Каждый элемент хранит значение и ссылку на следующий.
 */
public class MyList {

    /**
     * Узел списка
     */
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head; // начало списка

    /**
     * Добавление элемента в конец списка
     */
    public void add(int value) {

        Node newNode = new Node(value);

        // Если список пуст — новый элемент становится первым
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        // Проходим до последнего элемента
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    /**
     * Удаление первого вхождения элемента
     */
    public void remove(int value) {

        // Если список пуст
        if (head == null) {
            return;
        }

        // Если удаляем первый элемент
        if (head.value == value) {
            head = head.next;
            return;
        }

        Node current = head;

        // Ищем элемент перед удаляемым
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        // Если нашли — "перепрыгиваем" через него
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    /**
     * Поиск элемента
     */
    public boolean contains(int value) {

        Node current = head;

        // Перебираем все элементы
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Вывод списка
     */
    public void printList() {

        Node current = head;

        System.out.println("Список:");

        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}