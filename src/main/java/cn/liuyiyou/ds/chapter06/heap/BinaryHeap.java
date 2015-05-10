package cn.liuyiyou.ds.chapter06.heap;

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
	}

	public BinaryHeap(int capacity) {
	}

	public BinaryHeap(T[] items) {
		currentSize = items.length;
		array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];
		int i = 1;
		for (T item : items) {
			array[i++] = item;
		}
		buildHeap();
	}

	public T deleteMin() {
		if (isEmpty())
			throw new RuntimeException();

		T minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);
		return minItem;
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

	private void buildHeap() {
		for (int i = currentSize / 2; i > 0; i--) {
			percolateDown(i);
		}
	}

	private void enlargeArray(int newSize) {
	}

	public void insert(T t) {
		if (currentSize == array.length - 1)
			enlargeArray(array.length * 2 + 1);
		// 上滤
		int hole = ++currentSize;
		for (; hole > 1 && t.compareTo(array[hole / 2]) < 0; hole /= 2) {
			array[hole] = array[hole / 2];
		}
		array[hole] = t;
	}

	public T findMin() {

		return null;
	}

	public boolean isEmpty() {
		return true;
	}

	public void makeEmpty() {
	}

}
