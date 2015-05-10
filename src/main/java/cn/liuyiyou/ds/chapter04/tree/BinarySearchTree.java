package cn.liuyiyou.ds.chapter04.tree;

/**
 * 二叉查找树
 * @author liuyiyou
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

	private BinaryNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(T t) {
		return contains(t, root);
	}

	private boolean contains(T t, BinaryNode<T> root) {
		if (t == null)
			return false;

		int compareResult = t.compareTo(root.element);
		if (compareResult < 0) {
			return contains(t, root.left);
		} else if (compareResult > 0) {
			return contains(t, root.right);
		} else {
			return true;// 找到
		}
	}

	public T findMin() {
		if (isEmpty())
			throw new RuntimeException();
		return findMin(root).element;
	}

	private BinaryNode<T> findMin(BinaryNode<T> root) {
		if (root == null)
			return null;
		else if (root.left == null)
			return root;
		return findMin(root.left);
	}

	public T findMax() {
		if (isEmpty())
			throw new RuntimeException();
		return findMax(root).element;
	}

	private BinaryNode<T> findMax(BinaryNode<T> root) {
		if (root != null) {
			while (root.right != null) {
				root = root.right;
			}
		}

		return root;

	}

	public void insert(T t) {
		root = insert(t, root);
	}

	private BinaryNode<T> insert(T t, BinaryNode<T> root) {
		if (root == null) {
			return new BinaryNode<T>(t, null, null);
		}
		int compareResult = t.compareTo(root.element);
		if (compareResult < 0) {
			root.left = insert(t, root.left);
		} else if (compareResult > 0) {
			root.right = insert(t, root.right);
		} else {
			// 树中已经有该数据
		}

		return root;
	}

	public void remove(T t) {
		root = remove(t, root);
	}

	private BinaryNode<T> remove(T t, BinaryNode<T> root) {
		if (root == null)
			return root;
		int compareResult = t.compareTo(root.element);
		if (compareResult < 0) {
			root.left = remove(t, root.left);
		} else if (compareResult > 0) {
			root.right = remove(t, root.right);
		} else if (root.left != null && root.right != null) {
			// 两个孩子
			root.element = findMin(root.right).element;
			root.right = remove(root.element, root.right);
		} else {
			if (root.left != null) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return root;
	}

	private void printTree(BinaryNode<T> root) {

	}

	private static class BinaryNode<T> {

		T element;
		BinaryNode<T> left;
		BinaryNode<T> right;

		public BinaryNode(T element) {
			this(element, null, null);
		}

		public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}

}
