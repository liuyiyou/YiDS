package mark.allen.weiss.chapter03.list.copy;

public class TempSingle<E> {

	private Node<E> head;
	private int theSize;
	
	public TempSingle() {
		init();
	}

	public void init() {
		theSize = 0;
		head = new Node<E>();
		head.next = null;
	}

	public boolean contains(E e) {
		Node<E> p = head.next;
		while (p != null) {
			if (e.equals(p.data))
				return true;
			else
				return false;
		}

		return false;
	}

	public int size() {
		return theSize;
	}

	public void print() {
		Node<E> p = head.next;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}

		System.out.println();
	}

	public boolean add(E e) {
		if (contains(e)) {
			return false;
		} else {
			Node<E> p = new Node<E>(e);
			p.next = head.next;
			head.next = p;
			theSize++;
		}
		return true;
	}

	private class Node<E> {
		private E data;
		private Node<E> next;

		public Node() {
			this(null, null);
		}

		public Node(E data) {
			this(data, null);
		}

		public Node(E e, Node<E> next) {
			this.data = e;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		TempSingle<Integer> s = new TempSingle<Integer>();
		s.add(1);
		s.add(3);
		s.add(5);
		s.add(7);
		s.print();
		Integer l = new Integer(4);
		
	}
}
