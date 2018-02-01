package cn.liuyiyou.ds.chapter07.sort;

/**
 * 插入排序：插入排序包括 直接插入排序和希尔排序
 * 直接插入排序的基本操作是：将一个记录插入到已排好序的有序列表中，从而得到一个新的，记录数增1的有序表。
 * User: liuyiyou
 * Date: 14-8-25
 * Time: 下午5:14
 */
public class InsertSort2 {

    public static void insertSort1(int[] array) {

        //从位置1开始，0做为哨兵
        for (int i = 1; i < array.length; i++) {
            //保存当前位置到临时变量
            int temp = array[i];
            //将当前位置赋给紧邻的未排序的起点
            int j = i;
            //如果未排序的数小于已排序的树
            if (array[i - 1] > array[i]) {
                //向后移动一个位置
                while (j > 0 && array[j - 1] > temp) {     //只能是temp，不能是array[i] ,如果是array[i],在执行下面这句话的时候，array[i]会改的值被改变了
                    array[j] = array[j - 1];
                    j--;
                }
                //将当前位置存放为i
                array[j] = temp;    //同上，比如i为1的时候array[i]=3，array[j-1]为1，执行while里面的前移之后，array[j]=array[i]=3.而实际的情况应该是array[j]
            } else {
                System.out.println(i);
            }

        }
    }

    public static void insertSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];  //这个可以放在if里面
            int j = i;
            if (array[i] < array[i - 1]) {
                for (; j > 0 && temp < array[j - 1]; j--) {
                    array[j] = array[j - 1];
                }
                array[j] = temp;
            }
        }
    }


    //这个是错误的
    public static void insertBadSort1(int[] array) {

        for (int i = 1; i < array.length; i++) {

            if (array[i] < array[i - 1]) {
                array[0] = array[i];//先保存一下后面的那个

                array[i] = array[i - 1];// 前面的那个后移。

                int insertPos = 0;

                for (int k = i - 1; k >= 0; k--) {

                    if (array[k] > array[0]) {

                        array[k + 1] = array[k];

                    } else {

                        insertPos = k + 1;

                        break;

                    }

                }

                array[insertPos] = array[0];

            }

        }

    }


    //这个是错误的
    public static void insertBadSort2(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            if (array[j - 1] > temp) { //错误，a[j-1]>temp 即 a[i-1]>a[i] ，这个每次从外层循环都会成立，应该是a[i-1]>a[i]
                while (j >= 1 && (array[j - 1] > temp)) {
                    array[j] = array[j - 1];
                    j--;
                }
            }

        }
    }


    public static void main(String[] args) {

        int[] array = SortUtil.array;
        System.out.println("原始排序结果：");
        SortUtil.print(array);
        insertSort1(array);
        System.out.println("最终排序结果：");
        SortUtil.print(array);

    }
}
