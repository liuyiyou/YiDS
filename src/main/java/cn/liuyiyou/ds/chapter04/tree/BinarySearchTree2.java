package cn.liuyiyou.ds.chapter04.tree;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-22
 * Time: 下午11:36
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTree2<T extends Comparable<? super T>> implements SearchTree<T> {

    //这是树的根
    //树的相关方法都只保留树的根
    private Node<T> root;

    @Override
    public void makeEmpty() {
        root = null;
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEmpty() {
        return root == null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(T t) {

        return contains(t,root);  //To change body of implemented methods use File | Settings | File Templates.
    }

    private boolean contains(T t, Node<T> root){

        if (root == null){
            return false;
        } else {
          int result =   t.compareTo(root.element);
          if (result < 0){
              return  contains(t,root.left);
          } else if(result>0){
              return contains(t,root.right);
          }else {
              return true;
          }
        }
    }

    @Override
    public T findMax() {
        return findMax(root).element;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Node<T> findMax(Node<T> root) {

        if (root == null) {
            return null;
        } else if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    @Override
    public T findMin() {
        return findMin(root).element;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Node<T> findMin(Node<T> root) {
        if (root == null)
            return null;
        else if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    @Override
    public int height() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void insert(T t) {
        root = insert(t, root);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private Node<T> insert(T t, Node<T> root) {

        if (root == null) {
            return new Node<T>(t);
        }


        int compareResult = t.compareTo(root.element);
        if (compareResult < 0) {
            root.left = insert(t, root.left);
        } else if (compareResult > 0) {
            root.right = insert(t, root.right);
        } else {
        }


        return root;
    }

    @Override
    public void remove(T x) {
        root = remove(x,root);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Node<T> remove(T t, Node<T> root){
        if (root ==null){
            return null;
        }

        int compareResult = t.compareTo(root.element);
        if (compareResult < 0){
            root.left = remove(t,root.left);
        }else if (compareResult > 0){
            root.right = remove(t,root.right);
        } // 有两个节点
        else if (root.left != null && root.right != null) {
            root.element = findMin(root.right).element;
            root.right = remove(root.element, root.right);
        }else {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    @Override
    public void printTree() {
        if (isEmpty()) {
            System.out.println("是空树");
        } else {
            printTree(root);
        }
    }

    private void printTree(Node<T> t) {

        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        } else {
           // System.out.println("null");
        }
    }

    private static class Node<T> {

        private Node<T> left;
        private Node<T> right;
        private T element;


        public Node(T t) {
            this(null, null, t);
        }

        public Node(Node<T> left, Node<T> right, T t) {

            this.left = left;
            this.right = right;
            this.element = t;
        }
    }
}
