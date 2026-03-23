public class Main {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>(5);

        stack.push(5);
        stack.push(15);
        stack.push(25);

        stack.show();

        System.out.println("Верхний элемент: " + stack.peek());

        System.out.println("Удалили: " + stack.pop());

        stack.show();
    }
}