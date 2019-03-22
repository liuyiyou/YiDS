package mark.allen.weiss.chapter04.tree;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-8
 * Time: 下午7:41
 * 一般只保留对根节点的引用
 */
public class MyBinarySearchTree<T extends Comparable<? super T>> implements
        SearchTree<T> {

    private Node<T> root;

    @Override
    public void makeEmpty() {
        root = null;
    }

    @Override
    public boolean isEmpty() {

        return root == null;
    }

    @Override
    public boolean contains(T t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T findMax() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T findMin() {
        // TODO Auto-generated method stub
        return findMin(root);
    }

    private T findMin(Node<T> root) {

        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root.element;
        }


       return  findMin(root.left);


    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void insert(T x) {
        root = insert(x, root);
    }

    private Node<T> insert(T x, Node<T> root) {
        //如果是空树，则直接构造一个新节点
        if (root == null) {
            return new Node<T>(x, null, null);
        } else {
            //如果不是空树，则需要和root比较大小，如果是小于root，则插入左子树，如果比root大，则插入到右子树
            int result = x.compareTo(root.element);
            if (result < 0) {
                root.left = insert(x, root.left);
            } else if (result > 0) {
                root.right = insert(x, root.right);
            } else {

            }

        }


        return root;
    }

    @Override
    public void remove(T x) {
        // TODO Auto-generated method stub

    }

    @Override
    public void printTree() {
        if (isEmpty()) {
            System.out.println("是空树");
        } else {
            printTree(root);
        }
    }

    private void printTree(Node<T> root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.element);
            printTree(root.right);
        }
    }

    private static class Node<T> {
        private T element;
        private Node<T> left;
        private Node<T> right;

        public Node(T element, Node<T> left, Node<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public Node(T t) {
            this(t, null, null);
        }

    }

    public static void main(String[] args) {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
        tree.insert(4);
        tree.insert(3);
        tree.insert(5);
        tree.printTree();

        System.out.println(tree.findMin());
    }

}
