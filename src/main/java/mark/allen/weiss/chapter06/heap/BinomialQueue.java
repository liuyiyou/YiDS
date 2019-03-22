package mark.allen.weiss.chapter06.heap;

/**
 * 二项队列
 * 
 * @author liuyiyou
 *
 */
public class BinomialQueue<T extends Comparable<? super T>> {

	private static final int DEFAULT_TREES = 1;
	private int currentSize;
	private Node<T>[] theTrees;

	public BinomialQueue() {
	}

	public BinomialQueue(T item) {
	}

	/**
	 * 合并两个优先队列的
	 * 
	 * @param rhs
	 */
	public void merge(BinomialQueue<T> rhs) {

		if (this == rhs)
			return;

		currentSize += rhs.currentSize;
		if (currentSize > capacity()) {
			int maxLength = Math.max(theTrees.length, rhs.theTrees.length);
			expandTheTrees(maxLength + 1);
		}

		Node<T> carry = null;
		for (int i = 0, j = 1; j <= currentSize; i++, j *= 2) {
			Node<T> t1 = theTrees[i];
			Node<T> t2 = i < rhs.theTrees.length ? rhs.theTrees[i] : null;

			int whichCase = t1 == null ? 0 : 1;
			whichCase += t2 == null ? 0 : 2;
			whichCase += carry == null ? 0 : 4;

			switch (whichCase) {
			case 0:
			case 1:
				break;
			case 2:
				theTrees[i] = t2;
				rhs.theTrees[i] = null;
				break;

			case 4: // only carry
				theTrees[i] = carry;
				carry = null;
				break;

			case 3: // this and rhs
				carry = combineTrees(t1, t2);
				theTrees[i] = rhs.theTrees[i] = null;
				break;

			case 5:// this and carry
				carry = combineTrees(t1, carry);
				theTrees[i] = null;
				break;
			case 6: // rhs and carry
				carry = combineTrees(t1, carry);
				rhs.theTrees[i] = null;
				break;
			case 7:// all thee
				theTrees[i] = carry;
				carry = combineTrees(t1, t2);
				rhs.theTrees[i] = null;
				break;

			default:
				break;
			}
		}

		for (int k = 0; k < rhs.theTrees.length; k++) {
			rhs.theTrees[k] = null;
		}

		rhs.currentSize = 0;
	}

	public void insert(T x) {
		merge(new BinomialQueue<T>(x));
	}

	/**
	 * 二项队列的deleteMin，用到findMinIndex方法
	 * @return
	 */
	public T findMin() {
		if (isEmpty()) {
			return null;
		}

		int minIndex = findMinIndex();
		T minItem = theTrees[minIndex].element;
		Node<T> deleteTree = theTrees[minIndex].leftChild;

		// Construct H ''
		BinomialQueue<T> deleteQueue = new BinomialQueue<T>();
		deleteQueue.expandTheTrees(minIndex + 1);

		deleteQueue.currentSize = (1 << minIndex) - 1;
		
		for(int j = minIndex-1; j>=0; j--){
			deleteQueue.theTrees[j]= deleteTree;
			deleteTree = deleteTree.nextSibling;
			deleteQueue.theTrees[j].nextSibling=null;
		}
		
		// Construct H'
		theTrees[minIndex]=null;
		currentSize -= deleteQueue.currentSize+1;
		merge(deleteQueue);
		
		return minItem;
	}

	public T deleteMin() {
		return null;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public void makeEmpty() {
	}

	// private

	private void expandTheTrees(int newNumTrees) {
	}

	private int findMinIndex() {
		return 0;
	}

	/**
	 * 合并同样大小的两颗二项树
	 * 
	 * @param t1
	 * @param t2
	 * @return
	 */
	private Node<T> combineTrees(Node<T> t1, Node<T> t2) {
		if (t1.element.compareTo(t2.element) < 0)
			return combineTrees(t2, t1);

		t2.nextSibling = t1.leftChild;
		t1.leftChild = t2;
		return t1;
	}

	private int capacity() {
		return (1 << theTrees.length) - 1;
	}

	private static class Node<T> {
		T element;
		Node<T> leftChild;
		Node<T> nextSibling;

		public Node(T element) {
			this(element, null, null);
		}

		public Node(T element, Node<T> lt, Node<T> nt) {
			this.element = element;
			this.leftChild = lt;
			this.nextSibling = nt;
		}
	}
}
