public class Main {
    public static void main(String[] args) {

        MyList list = new MyList();

        list.add(10);
        list.add(20);
        list.add(30);

        list.printList();

        list.remove(20);

        list.printList();

        System.out.println("Есть 30: " + list.contains(30));
        System.out.println("Есть 50: " + list.contains(50));
    }
}