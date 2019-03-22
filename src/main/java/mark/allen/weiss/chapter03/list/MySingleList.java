package mark.allen.weiss.chapter03.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 单链表
 * 
 * @author liuyiyou
 *
 */
public class MySingleList<E> implements MyList<E> {

	private int theSize;

	private int modCount = 0;

	private Node<E> head;

	public MySingleList() {
		clear();
	}

	@Override
	public int size() {
		return theSize;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		Node<E> node = head.next;
		while (node != null) {
			if (node.data.equals(o)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new MySingleListItertor();
	}

	@Override
	public Object[] toArray() {
		Object[] objs = new Object[size()];
		Node<E> node = head.next;
		for (int i = 0; i < size(); i++, node = node.next) {
			objs[i] = node.data;
		}
		return objs;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(E e) {
		add(size(), e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		Node<E> before = head;
		Node<E> node = head.next;
		while (node != null) {
			if (node.data.equals(o)) {
				before.next = node.next;
				theSize--;
				return true;
			}
			before = node;
			node = node.next;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		head = new Node<E>(null, null);
		theSize = 0;

	}

	@Override
	public E get(int index) {
		return getNode(index).data;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = getNode(index);
		E old = node.data;
		node.data = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		// 这段代码为什么不行？ getNode(index)有什么问题
		// Node<E> indexNode = getNode(index);
		// Node<E> node = new Node<E>(element, indexNode.next);
		// indexNode.next = node;
		// theSize++;
		if (head.next == null) {
			Node<E> node = new Node<E>(element, null);
			head.next = node;
		} else {
			Node<E> node = head;// 不能为p = head.next。如果是p=head.next。会发生什么后果？如何修改
			// 该while循环有错误。如果从中间插入。则for循环会运行，改成if后可以。但是不必要。一定为true
			// if (node.next != null) {
			for (int i = 0; i < index; i++) {
				// head = head.next;
				// 不能用这个。head是list列表维持特性的引用，如果使用这句会发生什么后果？详细说明
				node = node.next;
			}

			// }
			Node<E> newNode = new Node<E>(element, node.next);
			node.next = newNode;
		}
		theSize++;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException("数组越界");
		// 不能调用该方法。该方法是返回指定的节点。而该节点是要删除的。得不到前驱节点
		// Node<E> removeNode = getNode(index);
		Node<E> node = head;
		E data = null;
		if (node.next == null) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<E> before = head;
			node = node.next;
			for (int i = 0; i < index; i++) {
				before = node;
				node = node.next;
			}
			before.next = node.next;
			data = node.data;
		}

		theSize--;
		return data;
	}

	@Override
	public int indexOf(Object o) {
		int index = -1;
		Node<E> node = head.next;
		while (node != null) {
			index++;
			if (node.data.equals(o)) {
				return index;
			}
			node = node.next;
		}
		return -1;// 不能返回index，因为index一直再累加
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		int last = index;
		Node<E> node = head.next;
		while (node != null) {
			index++;
			if (node.data.equals(o)) {
				// 并不直接返回，而是将出现的位置赋给last。如果后面有相同的值。last会重新更新该值。
				last = index;
			}
			node = node.next;

		}
		return last;// 不能返回index，因为index一直再累加
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// 这里同样需要注意 为什么这个循环不行？ 直接使用head = head.next进行迭代会破坏内部数据结构
		// while (head.next != null) {
		// head = head.next;
		// sb.append(head.data + "\t");
		// }
		Node<E> p = head;
		while (p.next != null) {
			p = p.next;
			sb.append(p.data + "\t");
		}
		return sb.toString();
	}
	

	/**
	 * 之前复用了这个方法，到后面觉得不行，因为效率会大大的降低
	 * @param index
	 * @return
	 */
	public Node<E> getNode(int index) {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException("数组越界");
		if (head.next == null) {
			return head;
		} else {
			Node<E> p = head;// 不能为p = head.next。如果是p=head.next。会发生什么后果？如何修改
			p = p.next;
			for (int i = 0; i < index; i++) {
				p = p.next;
			}
			return p;
		}
	}

	private static class Node<E> {
		// 节点数据
		public E data;

		// 后驱节点
		public Node<E> next;

		public Node(E data) {
			this(data, null);
		}

		/**
		 * 链表的节点构造函数
		 * 
		 * @param data
		 * @param next
		 */
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private class MySingleListItertor implements Iterator<E> {

		private Node<E> current = head.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;

		@Override
		public boolean hasNext() {
			return current.next == null;
		}

		@Override
		public E next() {
			return null;
		}

		@Override
		public void remove() {

		}
	}

	public static void main(String[] args) {
		// MySingleList<Integer> list = new MySingleList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		Integer l = 9;
		list.remove(l);
		System.out.println(list.toString());
		// System.out.println(list.getNode(0).data);
	}

}
