package mark.allen.weiss.chapter07.sort;

/**
 * 冒泡排序：
 * User: liuyiyou
 * Date: 14-8-21
 * Time: 下午4:04
 */
public class BubbleSort {


    /**
     * 这个是冒泡排序，冒泡排序是待排序的数和后面相邻的数比较大小
     * 注意内层循环中j的取值变化，之前i的初始值是1，j的临界值是array.length。
     * @param array
     */
    public static void bubbleSort1(int[] array){
        for (int i=0;i<array.length;i++){
            for (int j = 0; j<array.length-i-1;j++ ){
                if (array[j] > array[j+1]){
                    SortUtil.swap(array,j,j+1);
                }
            }
            SortUtil.print(array, i);
        }
    }


    /**
     *
     * @param array
     */
    public static void bubbleSort2(int[] array){
        for (int i=0;i<array.length;i++){
            for (int j = 0; j< i;j++ ){
                if (array[i]<array[j]){
                    SortUtil.swap(array,i,j);
                }
            }
            SortUtil.print(array, i);
        }
    }


    public static void bubbleSort3(int[] array) {
        for (int i = 0; i < array.length - 1; i++) { // 最多做n-1趟排序
            // 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) { // 把小的值交换到后面
                    SortUtil.swap(array, j, j + 1);
                }
            }

            SortUtil.print(array, i);
        }
    }





    public static void main(String [] args){


        int [] array = SortUtil.array;
        System.out.println("原始排序结果：");
        SortUtil.print(array);
        bubbleSort3(array);
        System.out.println("最终排序结果：");
        SortUtil.print(array);


    }

}
