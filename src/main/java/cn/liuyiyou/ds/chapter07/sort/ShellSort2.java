package cn.liuyiyou.ds.chapter07.sort;

/**
 * User: liuyiyou
 * Date: 14-9-4
 * Time: 下午8:16
 */
public class ShellSort2 {


    /**
     * 这个可以和前面的快速插入排序进行比较，会发现方法一模一样，只是快速插入的增量一直为1.而希尔排序增量是慢慢变小的。
     * */
    public static void shellSort1(int[] array){

        //增量 ,初始一般为数组的一半，最后为1
        int increment = array.length/2;
        while (increment>0){
            for (int i = increment ; i < array.length; i++){
                //保存当前位置到临时变量
                int temp = array[i];
                //将当前位置赋给紧邻的未排序的起点
                int j = i;
                //如果未排序的数小于已排序的树
                if (array[i-increment]>array[i]){
                    //向后移动一个位置
                    while (j>=increment && array[j-increment]> temp){     //只能是temp，不能是array[i] ,如果是array[i],在执行下面这句话的时候，array[i]会改的值被改变了
                        array[j] = array[j-increment];
                        j = j - increment;
                    }
                    //将当前位置存放为i
                    array[j] = temp;    //同上，比如i为1的时候array[i]=3，array[j-1]为1，执行while里面的前移之后，array[j]=array[i]=3.而实际的情况应该是array[j]
                } else {
                    System.out.println(i);
                }

            }

            increment = increment/2;

        }

    }

    public static void shellSort2(int[] array) {
        int count = 0;
        int j = 0;
        int temp = 0;
        for (int increment = array.length / 2; increment > 0; increment /= 2) {
            count++;
            for (int i = increment; i < array.length; i++) {
                temp = array[i];
                for (j = i; j >= increment; j -= increment) {
                    if(temp > array[j - increment]){
                        array[j] = array[j - increment];
                    }else{
                        break;
                    }
                }
                array[j] = temp;
            }
        }
        System.out.println(count);
    }



    public static void shellSort3(int[] array) {
        int j = 0;
        int temp = 0;
        int increment = array.length/2;
        while (increment>0){
            for (int i = increment; i < array.length; i++) {
                temp = array[i];
                j = i;
                while (j >= increment) {
                    if(temp > array[j - increment]){
                        array[j] = array[j - increment];
                    }else{
                        break;
                    }

                    j = j - increment;
                }
                array[j] = temp;


            }
            increment = increment/2;
        }
    }



    public static void main(String[] args) {

        int [] array = SortUtil.array;
        System.out.println("原始排序结果：");
        SortUtil.print(array);
        shellSort1(array);
        System.out.println("最终排序结果：");
        SortUtil.print(array);

    }
}
