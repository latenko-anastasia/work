public class Main {
    public static void main(String[] args) {

        MySet set = new MySet(5);

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // повтор

        set.printSet();

        set.remove(20);

        set.printSet();

        System.out.println("Есть 10: " + set.contains(10));
        System.out.println("Есть 50: " + set.contains(50));
    }
}