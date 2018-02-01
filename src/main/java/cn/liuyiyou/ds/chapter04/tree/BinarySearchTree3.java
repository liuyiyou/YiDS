package cn.liuyiyou.ds.chapter04.tree;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-8
 * Time: 下午7:38          测试在mac上上传
 * 二叉查找树
 */
public class BinarySearchTree3<AnyType extends Comparable<? super AnyType>> {

    private BinaryNode<AnyType> root;

    public BinarySearchTree3() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new RuntimeException();
        return findMin(root).element;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.left == null) {
            return t;
        }
        return findMin(t.right);

    }

    public AnyType findMax() {
        if (isEmpty())
            throw new RuntimeException();
        return findMax(root).element;
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t == null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        // if (t == null) {
        // return new BinaryNode(x, null, null);
        // }
        // int compareResult = x.compareTo(t.element);
        // if (compareResult < 0) {
        // return insert(x, t.left);
        // } else if (compareResult > 0) {
        // return insert(x, t.right);
        // } else {
        // }
        // return t;

        if (t == null) {
            return new BinaryNode<AnyType>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {
        }

        return t;

    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);

        }
        // 有两个节点
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("是空树");
        } else {
            printTree(root);
        }

    }

    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        } else {
            System.out.println("null");
        }
    }

    // 使用后续遍历计算树的高度
    public int height(BinaryNode<AnyType> t) {
        if (t == null)
            return -1;
        else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
    }

    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        @SuppressWarnings("unused")
        public BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        public BinaryNode(AnyType theElement, BinaryNode<AnyType> left,
                          BinaryNode<AnyType> right) {
            this.element = theElement;
            this.left = left;
            this.right = right;
        }

    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(4);
        tree.printTree();
    }

}
