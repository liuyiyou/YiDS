package cn.liuyiyou.ds.chapter07.sort;

/**
 * User: liuyiyou
 * Date: 14-8-21
 * Time: 下午6:02
 */
public class SortUtil {



    //待排序的数组
    public static int[]  array = {3,1,6,5,8,4,9,5,2,7};


    /**
     * 打印每次排序结构
     * @param array
     * @param i
     */
    public static  void print(int[] array,int  i){
        System.out.print("第" + (i + 1) + "次排序结果：");
        for (int a = 0; a < array.length; a++) {
            System.out.print(array[a] + "\t");
        }
        System.out.println("");

    }

    /**
     * 打印原始数组
     * @param array
     */
    public static void print(int [] array){
        for (int i = 0;i<array.length;i++){
            System.out.print(array[i] + "\t");
        }
        System.out.println();

    }

    /**
     * 交换数组元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
