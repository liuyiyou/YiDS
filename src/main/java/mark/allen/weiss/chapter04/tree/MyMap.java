package mark.allen.weiss.chapter04.tree;

/**
 * 用Tree实现Map
 * */
public class MyMap<K extends Comparable<? super K>, V> {
	
	private BinarySearchTree<K> tree;
	


	public MyMap() {
		tree = new BinarySearchTree<K>();
	}

	

}
