public class Main {
    public static void main(String[] args) {

        MyQueue<Integer> q = new MyQueue<>(5);

        q.add(100);
        q.add(200);
        q.add(300);

        q.showQueue();

        System.out.println("Первый элемент: " + q.front());

        System.out.println("Удалили: " + q.remove());

        q.showQueue();
    }
}