package cn.liuyiyou.ds.chapter06.heap;

import cn.liuyiyou.ds.UnderflowException;

/**
 * 
 * 优先队列
 * 
 * @author liuyiyou
 *
 * @param <T>
 */
public class BinaryHeap<T extends Comparable<? super T>> {

	private static final int DEFAULT_CAPACITY = 10;
	private int currentSize;
	private T[] array;

	public BinaryHeap() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public BinaryHeap(int capacity) {
		currentSize = 0;
		array = (T[]) new Comparable[capacity + 1];
	}

	@SuppressWarnings("unchecked")
	public BinaryHeap(T[] items) {
		currentSize = items.length;
		array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];

		int i = 1;
		for (T item : items) {
			array[i++] = item;
		}
		buildHeap();
	}

	public void insert(T x) {
		if (currentSize == array.length - 1)
			enlargeArray(array.length * 2 + 1);

		// Percolate up
		int hole = ++currentSize;
		for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
			array[hole] = array[hole / 2];
		array[hole] = x;
	}

	@SuppressWarnings("unchecked")
	private void enlargeArray(int newSize) {
		T[] old = array;
		array = (T[]) new Comparable[newSize];
		for (int i = 0; i < old.length; i++) {
			array[i] = old[i];
		}
	}

	public T findMin() {
		if (isEmpty())
			throw new UnderflowException();
		return array[1];
	}

	public T deleteMin() {
		if (isEmpty())
			throw new UnderflowException();

		T minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);
		return minItem;
	}

	private void buildHeap() {
		for (int i = currentSize / 2; i > 0; i--) {
			percolateDown(i);
		}
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public void makeEmpty() {
		currentSize = 0;
	}

	private void percolateDown(int hole) {
		int child;
		T temp = array[hole];
		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;
			if (child != currentSize
					&& array[child + 1].compareTo(array[child]) < 0) {
				child++;
			}
			if (array[child].compareTo(temp) < 0) {
				array[hole] = array[child];
			} else {
				break;
			}
		}

		array[hole] = temp;
	}

	public static void main(String[] args) {
		int numItems = 10000;
		BinaryHeap<Integer> h = new BinaryHeap<Integer>();
		int i = 37;

		for (i = 37; i != 0; i = (i + 37) % numItems)
			h.insert(i);
		for (i = 1; i < numItems; i++)
			if (h.deleteMin() != i)
				System.out.println("Oops! " + i);
	}
}
