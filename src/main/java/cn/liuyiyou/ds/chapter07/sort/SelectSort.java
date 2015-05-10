package cn.liuyiyou.ds.chapter07.sort;

/**
 * 选择排序
 * 
 * @author liuyiyou
 *
 */
public class SelectSort {

	// 每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。 选择排序是不稳定的排序方法。
	public static void selectSort(int[] array) {
		if ((array == null) || (array.length == 0))
			return;
		int minIndex = 0;
		for (int i = 0; i < array.length; i++) {
			minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	public static void selectSort3(int[] array) {
		for (int i = 0; i < array.length; i++) {
			//默认当前位置最小
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				//如果未排序的元素比当前元素小，则将该元素的索引赋给最小元素的索引
				if (array[minIndex] > array[j])
					minIndex = j;
			}
			//第i个元素与最小元素进行交换
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	public static void selectSort2(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int minIndex = findMinIndex(array, i);
			swap(array, i, minIndex);
		}
	}

	public static int findMinIndex(int[] array, int i) {
		int minIndex = i;
		for (int j = i + 1; j < array.length; j++) {
			if (array[minIndex] > array[j]) {
				minIndex = j;
			}
		}
		System.out.println("第" + (i) + "小的" + array[minIndex]);
		return minIndex;
	}

	public static void swap(int[] array, int i, int minIndex) {
		int temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;

	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 4, 9, 5, 3 };
		selectSort3(a);
		// int min = findMinIndex(a, 4);
		// System.out.println(min);
		for (int i : a) {
			System.out.println(i);
		}
	}

}


