package cn.liuyiyou.ds.chapter03.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {

	private static class Node<T> {
		// 节点数据
		public T data;
		// 前驱节点
		public Node<T> prev;
		// 后驱节点
		public Node<T> next;

		/**
		 * 链表的节点构造函数
		 * 
		 * @param data
		 * @param prev
		 * @param next
		 */
		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	// 列表大小 ：因为父类已经有该字段。而且父类有的方法已经使用了该字段。如果这里也加了的话。会有问题
	private int theSize;

	private int modCount = 0;

	// 首指针
	private Node<T> beginMarker;
	// 尾指针
	private Node<T> endMarker;

	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * 构造函数
	 */
	public MyLinkedList() {
		clear();
	}

	/**
	 * 列表大小.为什么这里不写实现，直接调用他的超类不行？
	 * 
	 * @return
	 */
	public int size() {
		return theSize;
	}

	/**
	 * 清空列表：
	 * 
	 * 1、头节点数据为空且后驱节点指向尾节点（因为此时尾节点还未初始化，需要等到尾节点初始化） 2、尾节点数据位空且前驱指向头结点 3、1的括号里面的
	 * 4、大小为0
	 */
	public void clear() {
		// 首指针为空
		beginMarker = new Node<T>(null, null, null);
		// 尾指针后继为空，前驱为begainMarker
		endMarker = new Node<T>(null, beginMarker, null);
		beginMarker.next = endMarker;
		theSize = 0;
		modCount++;
	}

	/**
	 * 加入列表尾部。
	 *
	 * @param <T>
	 */

	public boolean add(T t) {
		add(size(), t);
		return true;
	}

	/**
	 * 在指定节点添加数据。一般来讲，是从尾节点添加。
	 * 
	 * @param index
	 * @param t
	 */
	public void add(int index, T t) {
		System.out.println(index);
		System.out.println(getNode(index).data);
		addBefore22(getNode(index), t);
	}

	// addBefore和.addBefore2都可以

	private void addBefore11(Node<T> p, T t) {
		// 新建节点。切初始化的时候，其前驱为p的前驱。后继为p
		Node<T> newNode = new Node<T>(t, p.prev, p);
		// newNode的前驱和后继已经确定。只要将p.prev和p.prev.next重新分配即可
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}

	private void addBefore12(Node<T> p, T t) {
		// 新建节点。切初始化的时候，其前驱为p的前驱。后继为p
		Node<T> newNode = new Node<T>(t, p.prev, p);
		// newNode的前驱和后继已经确定。只要将p.prev和p.prev.next重新分配即可
		p.prev = newNode;
		newNode.prev.next = newNode;
		theSize++;
		modCount++;
	}

	/**
	 * 
	 * @param node
	 * @param t
	 */
	private void addBefore21(Node<T> node, T t) {
		Node<T> newNode = new Node<T>(t, node.prev, node);
		node.prev.next = newNode;
		node.prev = newNode;
		theSize++;
		modCount++;
	}

	/**
	 * 这个有错误：
	 * 
	 * @param node
	 * @param t
	 */
	private void addBefore22(Node<T> node, T t) {
		Node<T> newNode = new Node<T>(t, node.prev, node);
		node.prev = newNode;
		/**
		 * node.prev=newNode之后。 node.prev.next已经无法指向了。
		 * 只能用newNode.prev.next=newNode。这样便和addBefore12()一样了。
		 **/
		node.prev.next = newNode;
		theSize++;
		modCount++;
	}

	/**
	 * 为什么这个可以呢？
	 * @param node
	 * @param t
	 */
	private void addBefore31(Node<T> node, T t) {
		/**
		 * 下面的语句相当于：
		 * node.prev = newNode;
		 * node.prev.next = newNode;
		 */
		node.prev.next = node.prev = new Node<T>(t, node.prev, node);
		theSize++;
		modCount++;
	}
	

	/**
	 * 
	 * @param node
	 * @param t
	 */
	private void addBefore32(Node<T> node, T t) {
		
		node.prev = node.prev.next = new Node<T>(t, node.prev, node);
		theSize++;
		modCount++;
	}

	public T get(int index) {
		return getNode(index).data;
	}

	public Iterator<T> iterator() {
		return new LinedListIterator();
	}

	public T set(int index, T t) {
		Node<T> p = getNode(index);
		T old = p.data;
		p.data = t;
		return old;
	}

	public T remove(int index) {
		return remove(getNode(index));
	}

	public void print(MyLinkedList<T> list) {
		Iterator<T> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + "\t");
		}

		System.out.println();
	}

	private T remove(Node<T> p) {
		p.next.prev = p.prev;
		p.prev.next = p.next;
		theSize--;
		modCount++;

		return p.data;
	}

	public boolean contains(T t) {
		Node<T> p = beginMarker.next;

		while (p != endMarker && !(p.data.equals(t))) {
			p = p.next;
		}
		// 如果一直没有找到，则p==endMarker
		return p != endMarker;
	}

	/**
	 * 单链表：可以使用双链表，只是不使用他的prev方法
	 */
	public void swapWithNext1(Node<T> beforeP) {
		Node<T> p;
		Node<T> afterP;
		p = beforeP.next;
		afterP = p.next;

		p.next = afterP.next;
		beforeP.next = afterP;
		afterP.next = p;

	}

	public void swapWithNext2(Node<T> p) {
		Node<T> beforeP;
		Node<T> afterP;

		beforeP = p.prev;
		afterP = p.next;

		p.next = afterP.next;
		beforeP.next = afterP;
		afterP.next = p;
		p.next.prev = p;
		p.prev = afterP;
		afterP.prev = beforeP;

	}

	public Node<T> getNode(int index) {
		Node<T> p;
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		// 根据索引位置，得到节点，如果索引偏前，则从链表前面开始，否则从后面开始
		if (index < size() / 2) {
			p = beginMarker.next;
			for (int i = 0; i < index; i++) {
				p = p.next;
			}
		} else {
			p = endMarker;
			for (int i = size(); i > index; i--) {
				p = p.prev;
			}
		}

		return p;
	}

	private class LinedListIterator implements Iterator<T> {

		private Node<T> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;

		@Override
		public boolean hasNext() {
			return current != endMarker;
		}

		@Override
		public T next() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if (!hasNext())
				throw new NoSuchElementException();
			T nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}

		@Override
		public void remove() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if (!okToRemove)
				throw new IllegalStateException();
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount++;
		}

	}

}
