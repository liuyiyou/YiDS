package mark.allen.weiss.chapter07.sort;

/**
 * User: liuyiyou
 * Date: 14-8-21
 * Time: 下午6:02
 */
public class SortUtil {


    //待排序的数组
    public static int[] array = {3, 1, 6, 5, 8, 4, 9, 5, 2, 7};


    /**
     * 打印每次排序结构
     *
     * @param array
     * @param i
     */
    public static void print(int[] array, int i) {
        System.out.print("第" + (i + 1) + "次排序结果：");
        for (int a = 0; a < array.length; a++) {
            System.out.print(array[a] + "\t");
        }
        System.out.println("");

    }

    /**
     * 打印原始数组
     *
     * @param array
     */
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();

    }

    /**
     * 交换数组元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /************下面说的工具类来自算法（4）******************/

    /**
     * 比较
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 打印
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 验证是否有序
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        System.out.println("is Sorted");
        return true;
    }
}
