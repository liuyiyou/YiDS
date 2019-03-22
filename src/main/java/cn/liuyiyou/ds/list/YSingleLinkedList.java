package cn.liuyiyou.ds.list;


/**
 * @author: liuyiyou.cn
 * @date: 2019/3/22
 * @version: V1.0
 */
public class YSingleLinkedList<T> implements YList<T> {


    //ADT
    private int size;
    //header做为哨兵，不参与
    private Node<T> header;

    public YSingleLinkedList() {
        this.size = 0;
        this.header = new Node<>(null, null);
    }

    @Override
    public void clear() {
        size = 0;
        this.header = new Node<>(null, null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(T t) {
        Node<T> tNode = new Node<>(t, null);
        if (header.next == null) {
            header.next = tNode;
        } else {
            Node<T> lastNode = header;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = tNode;
        }
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size())
            throw new ArrayIndexOutOfBoundsException("数组越界");
        Node<T> beforeNode = getNode(index - 1);
        Node<T> indexNode = getNode(index);
        if (beforeNode == indexNode) {
            beforeNode.next = indexNode.next.next;
        }else {
            beforeNode.next = indexNode.next;
        }
        size--;
        return indexNode.t;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("数组越界");
        Node<T> lastNode = getNode(index);
        return lastNode.t;
    }


    @Override
    public T set(int index, T t) {
        Node<T> node = getNode(index);
        T old = node.t;
        node.t = t;
        return old;
    }

    private Node<T> getNode(int index) {
        Node<T> lastNode = header.next;
        for (int i = 0; i < index; i++) {
            lastNode = lastNode.next;
        }
        return lastNode;
    }

    @Override
    public void print() {
        Node<T> node = header;
        while (node.next != null) {
            node = node.next;
            System.out.print(node.t + "\t");
        }
        System.out.println();
    }


    private static class Node<T> {
        private T t;
        private Node<T> next;

        Node(T t, Node<T> next) {
            this.t = t;
            this.next = next;
        }


        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
