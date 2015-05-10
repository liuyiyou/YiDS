package cn.liuyiyou.ds.chapter07.sort;

public class InsertSort {

	public static <T extends Comparable<? super T>> void insertSort(T[] tArray) {
		for (int i = 1; i < tArray.length; i++) {
			T temp = tArray[i]; // 这个可以放在if里面
			int j = i;
			if (tArray[i].compareTo(tArray[i - 1]) < 0) {
				for (; j > 0 && temp.compareTo(tArray[j - 1]) < 0; j--) {
					tArray[j] = tArray[j - 1];
				}
				tArray[j] = temp;
			}
		}
	}

	public static void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	public static void insertSort2(int[] array) {

		for (int i = 1; i < array.length; i++) {
			// 从i个元素开始，依次与i之前的元素进行比较
			for (int j = i; j > 0; j--) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				} else {
					//快速退出
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		// Integer[] tArray = { 2, 3, 4, 9, 5, 1 };
		// InsertSort.insertSort(tArray);
		// for (Integer i : tArray) {
		// System.out.println(i);
		// }

		int[] a = { 2, 1, 4, 9, 5, 3 };
		InsertSort.insertSort2(a);
		for (int i : a) {
			System.out.println(i);
		}

	}

}
