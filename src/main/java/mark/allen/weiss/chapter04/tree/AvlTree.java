package mark.allen.weiss.chapter04.tree;

import mark.allen.weiss.UnderflowException;

public class AvlTree<T extends Comparable<? super T>> {

	private AvlNode<T> root;

	public AvlTree() {
		root = null;
	}

	public void insert(T x) {
		root = insert(x, root);
	}

	public void remove(T x) {
		System.out.println("remoe unimplemented");
	}

	public T findMin() {
		if (isEmpty())
			throw new UnderflowException();
		return findMin(root).element;
	}

	public T findMax() {
		if (isEmpty())
			throw new UnderflowException();
		return findMax(root).element;
	}

	public boolean contains(T x) {
		return contains(x, root);
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	private AvlNode<T> insert(T x, AvlNode<T> t) {
		if (t == null) {
			return new AvlNode<T>(x, null, null);
		}
		int compareResult = x.compareTo(t.element);

		if (compareResult < 0) {
			t.left = insert(x, t.left);
			if (height(t.left) - height(t.right) == 2) {
				if (x.compareTo(t.left.element) < 0) {
					t = rotateWithLeftChild(t);
				} else {
					t = doubleWithLeftChild(t);
				}
			}
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
			if (height(t.right) - height(t.left) == 2) {
				if (x.compareTo(t.right.element) > 0) {
					t = rotateWithRightChild(t);
				} else {
					t = doubleWithRightChild(t);
				}
			}
		} else {
			// Duplicate ;do nothing
		}

		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private AvlNode<T> findMin(AvlNode<T> t) {
		if (t == null)
			return t;

		while (t.left != null) {
			t = t.left;
		}
		return t;
	}

	private AvlNode<T> findMax(AvlNode<T> t) {
		if (t == null)
			return t;
		while (t.right != null) {
			t = t.right;
		}

		return t;
	}

	private boolean contains(T x, AvlNode<T> t) {
		while (t != null) {
			int compareResult = x.compareTo(t.element);
			if (compareResult < 0) {
				t = t.left;
			} else if (compareResult > 0) {
				t = t.right;
			} else {
				return true;
			}
		}
		return false;
	}

	public void printTree() {
		printTree(root);
	}

	private void printTree(AvlNode<T> t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

	private int height(AvlNode<T> t) {
		return t == null ? -1 : t.height;
	}

	/**
	 * 单旋转
	 * 
	 * @param k2
	 * @return
	 */
	private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
		AvlNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;

		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;

		return k1;
	}

	private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
		AvlNode<T> k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;

		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;

		return k2;

	}

	private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	private static class AvlNode<T> {

		private T element;
		private AvlNode<T> left;
		private AvlNode<T> right;
		private int height;

		public AvlNode(T element) {
			this(element, null, null);
		}

		public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
			this.element = element;
			this.left = left;
			this.right = right;
			this.height = 0;
		}

	}

	public static void main(String[] args) {
		AvlTree<Integer> t = new AvlTree<Integer>();
		final int NUMS = 4000;
		final int GAP = 37;

		System.out.println("Checking... (no more output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			t.insert(i);

		if (NUMS < 40)
			t.printTree();
		if (t.findMin() != 1 || t.findMax() != NUMS - 1)
			System.out.println("FindMin or FindMax error!");

		for (int i = 1; i < NUMS; i++)
			if (!t.contains(i))
				System.out.println("Find error1!");
	}

}
