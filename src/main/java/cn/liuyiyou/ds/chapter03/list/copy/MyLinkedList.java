package cn.liuyiyou.ds.chapter03.list.copy;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int theSize;
	private int modCount;

	private static class Node<T> {
		private Node<T> prev;
		private Node<T> next;
		private T data;

		public Node(T data, Node<T> prev, Node<T> next) {
			super();
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
	}

	public MyLinkedList() {
		clear();
	}

	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return theSize == 0;
	}

	public void clear() {

		head = new Node<T>(null, null, null);
		tail = new Node<T>(null, head, null);
		head.next = tail;
		theSize = 0;
		modCount++;
	}

	public Node<T> getNode(int index) {

		if (index < 0 || index > size())
			return null;
		Node<T> node;
		if (index < size() / 2) {
			node = head;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
		} else {
			node = tail;
			for (int i = size(); i > index; i--) {
				node = node.prev;
			}
		}

		return node;
	}

	public boolean add(T t) {
		add(size(), t);
		return true;
	}

	private void add(int index, T t) {
		 addBefore(getNode(index), t);
//		addAfter(getNode(index), t);
	}

	// 在prev前插入
	public void addBefore(Node<T> beforeNode, T t) {
		Node<T> newNode = new Node<T>(t, beforeNode.prev, beforeNode);
//		newNode.prev.next = newNode;
//		newNode.next.prev = newNode;
		beforeNode.prev.next = newNode;
		beforeNode.prev = newNode;
		theSize++;
		modCount++;
	}

	public void addAfter(Node<T> afterNode, T t) {
		Node<T> newNode = new Node<T>(t, afterNode, afterNode.next);
//		newNode.prev.next = newNode;
//		newNode.next.prev = newNode;
		afterNode.prev.next = newNode;
		afterNode.prev = newNode;
		theSize++;
		modCount++;
	}

	public Iterator<T> iterator() {
		return new LinedListIterator();
	}

	private class LinedListIterator implements Iterator<T> {

		private Node<T> current = head.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;

		@Override
		public boolean hasNext() {
			return current != tail;
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
			// if (modCount != expectedModCount)
			// throw new ConcurrentModificationException();
			// if (!okToRemove)
			// throw new IllegalStateException();
			// MyLinkedList.this.remove(current.prev);
			// okToRemove = false;
			// expectedModCount++;
		}

	}

	public void print(MyLinkedList<T> list) {
		Iterator<T> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + "\t");
		}

		System.out.println();
	}

}
