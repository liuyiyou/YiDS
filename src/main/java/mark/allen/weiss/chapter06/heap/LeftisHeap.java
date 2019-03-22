package mark.allen.weiss.chapter06.heap;

/**
 * 左式堆
 *
 * @author liuyiyou
 */
public class LeftisHeap<T extends Comparable<? super T>> {

    private Node<T> root;

    public LeftisHeap() {
        root = null;
    }

    public void merge(LeftisHeap<T> rhs) {
        if (this == rhs) {
            return;
        }
        root = merge(root, rhs.root);
        rhs.root = null;

    }

    /**
     * 左式堆插入
     *
     * @param t
     */
    public void insert(T t) {
        root = merge(new Node<T>(t), root);
    }

    public T findMin() {
        return null;
    }

    public T deleteMin() {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        T minItem = root.element;
        root = merge(root.left, root.right);
        return minItem;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    // private

    private Node<T> merge(Node<T> h1, Node<T> h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        if (h1.element.compareTo(h2.element) < 0) {
            return merge1(h1, h2);
        } else {
            return merge1(h2, h1);
        }
    }

    private Node<T> merge1(Node<T> h1, Node<T> h2) {
        if (h1.left == null) {
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl) {
                swapChildren(h1);
            }
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChildren(Node<T> t) {
    }

    private static class Node<T> {
        T element;
        Node<T> left;
        Node right;
        int npl;

        public Node(T theElement) {
            this(theElement, null, null);
        }

        public Node(T theElement, Node<T> left, Node<T> right) {
            this.element = theElement;
            this.left = left;
            this.right = right;
            npl = 0;
        }
    }
}
