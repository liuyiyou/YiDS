package mark.allen.weiss.chapter07.sort;

/**
 * 每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。 选择排序是不稳定的排序方法。
 * User: liuyiyou
 * Date: 14-8-21
 * Time: 下午5:28
 */
public class SelectSort2 {


    //每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。 选择排序是不稳定的排序方法。
    public static void selectSort(int[] array) {
        if ((array == null) || (array.length == 0)) return;
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            SortUtil.swap(array,i, minIndex);
            SortUtil.print(array,i);
        }
    }


    //这个就是稳定算法了
    public static void selectSort2(int array[]) {
        int minIndex = 0;
        if ((array == null) || (array.length == 0)) return;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;//无序区的最小数据数组下标
            for (int j = i + 1; j < array.length; j++) {//在无序区中找到最小数据并保存其数组下标
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {//如果不是无序区的最小值位置且不是默认的第一个数据，则交换之。
                SortUtil.swap(array,i,minIndex);
            }
            SortUtil.print(array,i);
        }
    }


    public static void main(String[] args) {

        int [] array = SortUtil.array;
        System.out.println("原始排序结果：");
        SortUtil.print(array);
        selectSort2(array);
        System.out.println("最终排序结果：");
        SortUtil.print(array);

    }
}
