public class Main {
    public static void main(String[] args) {

        MyBinaryTree<Integer> tree = new MyBinaryTree<>();

        tree.add(45);
        tree.add(20);
        tree.add(65);
        tree.add(10);
        tree.add(30);
        tree.add(50);
        tree.add(70);

        System.out.println("Элементы дерева:");
        tree.print();

        System.out.println("Поиск 30: " + tree.find(30));
        System.out.println("Поиск 100: " + tree.find(100));
    }
}