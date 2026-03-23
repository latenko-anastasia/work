/**
 * Класс MyBinaryTree реализует бинарное дерево поиска.
 * Значения меньшие идут влево, большие — вправо.
 */
public class MyBinaryTree<T extends Comparable<T>> {

    /**
     * Внутренний класс узла дерева
     */
    private class TreeNode {
        T data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(T data) {
            this.data = data;
        }
    }

    private TreeNode root;

    /**
     * Добавление элемента в дерево
     */
    public void add(T value) {
        root = addNode(root, value);
    }

    /**
     * Рекурсивное добавление узла
     */
    private TreeNode addNode(TreeNode node, T value) {

        // Если нашли пустое место — вставляем
        if (node == null) {
            return new TreeNode(value);
        }

        // Определяем, куда идти дальше
        if (value.compareTo(node.data) < 0) {
            node.leftChild = addNode(node.leftChild, value);
        } else if (value.compareTo(node.data) > 0) {
            node.rightChild = addNode(node.rightChild, value);
        }

        return node;
    }

    /**
     * Проверка наличия элемента
     */
    public boolean find(T value) {
        return findNode(root, value);
    }

    private boolean findNode(TreeNode node, T value) {

        if (node == null) return false;

        if (value.equals(node.data)) return true;

        // Переход в левую или правую ветку
        if (value.compareTo(node.data) < 0) {
            return findNode(node.leftChild, value);
        } else {
            return findNode(node.rightChild, value);
        }
    }

    /**
     * Прямой обход дерева (in-order)
     */
    public void print() {
        printTree(root);
        System.out.println();
    }

    private void printTree(TreeNode node) {

        if (node == null) return;

        // Левое поддерево → узел → правое поддерево
        printTree(node.leftChild);
        System.out.print(node.data + " ");
        printTree(node.rightChild);
    }
}