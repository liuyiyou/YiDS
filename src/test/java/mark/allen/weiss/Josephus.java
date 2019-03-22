package mark.allen.weiss;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-8
 * Time: 下午7:32
 * Josephus环
 */
public class Josephus {

    private Node head;
    private int size;

    // 1:构造循环列表
    private class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return head == head.next;
    }

    public Josephus() {
        Node head = new Node(-1);
        head.next = head;
    }

    public void add(int i) {
        Node newNode = new Node(i);
        head.next = newNode;
        size++;
    }

    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        System.out.println(josephus.isEmpty());
    }

}

