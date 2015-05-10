package cn.liuyiyou.ds.chapter07.sort;

public class SortSumSimple {

	/**
	 * 关键点：两两交换
	 *
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		System.out.print("初始列表为：\t\t");
		print(a);
		for (int i = 0; i < a.length - 1; i++) { // 最多做n-1趟排序
			// 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) { // 把小的值交换到后面
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

				// 这里可以看到具体交换
			}
			System.out.print("第" + (i + 1) + "次排序后的列表为：\t");
			print(a);
		}
	}

	/**
	 * 关键点：从第1个元素开始，每次选择到最小索引
	 *
	 * @param a
	 */
	public static void selectSort(int[] a) {
		System.out.print("初始列表为：\t\t");
		print(a);
		int minIndex = 0;
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIndex])
					minIndex = j;
			}
			// swap
			temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
			System.out.print("第" + (i + 1) + "次排序后的列表为：\t");
			print(a);
		}
	}

	/**
	 * 关键点：待排序的数在已排序数的位置
	 *
	 * @param a
	 */
	public static void insertSort(int[] a) {
		System.out.print("初始列表为：\t\t");
		print(a);
		int j;
		for (int i = 1; i < a.length; i++) {
			if (a[i] - a[i - 1] < 0) {
				int temp = a[i]; // 这个可以放在if里面
				for (j = i; j > 0 && temp - a[j - 1] < 0; j--) {
					a[j] = a[j - 1];
				}
				a[j] = temp;
			}
			System.out.print("第" + (i + 1) + "次排序后的列表为：\t");
			print(a);
		}
	}

	/**
	 * 希尔排序
	 *
	 * @param a
	 */
	public static void shellSort(int[] a) {
		System.out.print("初始列表为：\t\t");
		print(a);
		int step = 1;
		int j;
		while (step <= a.length / 3)
			step = step * 3 + 1;
		while (step > 0) {
			for (int i = step; i < a.length; i++) {
				int temp = a[i];
				j = i;
				while (j > step - 1 && a[j - step] >= temp) {
					a[j] = a[j - step];
					j = j - step;
				}
				a[j] = temp;
				System.out.print("第" + (i + 1) + "次排序后的列表为：\t");
				print(a);
			}
			step = (step - 1) / 3;
		}
	}

	/**
	 * 快速排序
	 *
	 * @param a
	 * @param low
	 * @param hight
	 */
	public static void quickSort(int[] a, int low, int hight) {
		int i = 0;
		if (low < hight) {
			int povitePosition = partition(a, low, hight);
			quickSort(a, low, povitePosition - 1);
			quickSort(a, povitePosition + 1, hight);
			i++;
		}
		System.out.print("第" + (i + 1) + "次排序后的列表为：\t");
		print(a);
	}

	private static int partition(int[] o, int low, int hight) {
		// 选定枢轴为low所对应的值
		int pivote = o[low];
		while (low < hight) {
			// 高位找到比povite大，则符合要求，继续寻找
			while (hight > low && pivote - o[hight] <= 0) {
				hight--;
			}
			o[low] = o[hight];
			// 低位开始找到比povite小，符合要求，继续寻找
			while (low < hight && pivote - o[low] >= 0) {
				low++;
			}
			o[hight] = o[low];
		}
		o[low] = pivote;
		return low;
	}

	/**
	 * 单基准排序
	 *
	 * @param a
	 */
	public static void hoareSort(int[] a) {
	}

	/**
	 * 三路快排序
	 *
	 * @param a
	 */
	public static void Sedgewick(int[] a) {
	}

	/**
	 * 新双基准
	 *
	 * @param a
	 */
	public static void Yaroslavskiy(int[] a) {

	}

	/**
	 * 堆排序
	 *
	 * @param sorted
	 */
	public static void heapSort(int[] a) {
		for (int i = a.length / 2; i > 0; i--) {
			heapAdjust(a, i, a.length);
		}
		for (int i = a.length; i > 1; --i) {
			exchange(a, 1, i);
			heapAdjust(a, 1, i - 1);

		}
	}

	/**
	 * 归并排序
	 */
	public static void mergeSort() {

	}

	/**
	 * 基数排序
	 *
	 * @param a
	 */
	public static void radixSort() {
	}

	private static void heapAdjust(int[] a, int start, int end) {
		if (start < end) {
			int temp = a[start];
			// 这个地方j<end与课本不同，j<=end会报错：
			for (int j = 2 * start; j < end; j *= 2) {
				if (j + 1 < end && a[j] - a[j + 1] > 10e-6) {
					++j;
				}
				if (temp <= a[j]) {
					break;
				}
				a[start] = a[j];
				start = j;
			}
			a[start] = temp;
		}
	}

	private static void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}

	private static void exchange(int[] a, int i, int j) {
		if (i < a.length && j < a.length && i < j && i >= 0 && j >= 0) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] a1 = { 3, 1, 7, 4, 2, 6, 10, 9 };
		int[] a2 = { 3, 1, 7, 4, 2, 6, 10, 9 };
		int[] a3 = { 3, 1, 7, 4, 2, 6, 10, 9 };
		int[] a4 = { 3, 1, 7, 4, 2, 6, 10, 9 };
		int[] a5 = { 3, 1, 7, 4, 2, 6, 10, 9 };
		int[] a6 = { 3, 1, 7, 4, 2, 6, 10, 9 };
		System.out
				.println("*********************冒泡排序************************************");
		SortSumSimple.bubbleSort(a1);
		System.out
				.println("*********************选择排序************************************");
		SortSumSimple.selectSort(a2);
		System.out
				.println("*********************插入排序************************************");
		SortSumSimple.insertSort(a3);
		System.out
				.println("*********************希尔排序************************************");
		SortSumSimple.shellSort(a4);
		System.out
				.println("*********************快速排序************************************");
		System.out.print("初始列表为：\t\t");
		print(a5);
		SortSumSimple.quickSort(a5, 0, a5.length - 1);
		System.out
				.println("**********************堆排序************************************");
		System.out.print("初始列表为：\t\t");
		print(a6);
		SortSumSimple.heapSort(a6);
		print(a6);
	}
}
