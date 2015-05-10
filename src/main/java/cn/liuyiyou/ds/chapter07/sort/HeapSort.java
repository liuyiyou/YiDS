package cn.liuyiyou.ds.chapter07.sort;

/**
 * 堆排序
 * 
 * @author liuyiyou
 *
 */
public class HeapSort {

	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	public static <T extends Comparable<? super T>> void percDown(T[] tArray,
			int i, int n) {
		int child = 0;
		T temp;
		for(temp=tArray[i];leftChild(i)<n;i=child){
			
		}
	}
	
	public static <T extends Comparable<? super T>> void heapSort(T[] tArray){
		
	}

}
