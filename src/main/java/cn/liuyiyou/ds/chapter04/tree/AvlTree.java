package cn.liuyiyou.ds.chapter04.tree;

public class AvlTree<T extends Comparable<? super T>> {

	private int height(AvlNode<T> t) {
		return t == null ? -1 : t.height;
	}

	private AvlNode<T> insert(T t, AvlNode<T> root) {
		if (t == null)
			return new AvlNode<T>(t, null, null);
		int compareResult = compare(t, root.element);
		if (compareResult < 0) {
		}

		return null;
	}

	private int compare(T t, T element) {
		// TODO Auto-generated method stub
		return 0;
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

}
