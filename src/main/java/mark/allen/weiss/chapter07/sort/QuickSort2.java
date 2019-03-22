package mark.allen.weiss.chapter07.sort;

/**
 * User: liuyiyou
 * Date: 14-9-9
 * Time: 下午9:50
 * 快速排序
 */
public class QuickSort2 {

    public static void quickSort1(int[] array,int left,int right){

        int i = left;
        int j = right;
        int temp = array[left];
        while (i!=j){
            while (i<j && array[j]>=temp)
                j--;
            while (i<j && array[i]<=temp)
                i++;
            if (i<j)
                SortUtil.swap(array,i,j);
        }
        array[left] = array[i];
        array[i] = temp;
        quickSort1(array, left, j-1);
        quickSort1(array, i+1, right);

    }


    public static void main(String[] args) {

        int[] array = SortUtil.array;
        System.out.println("原始排序结果：");
        SortUtil.print(array);
        quickSort1(array,0,array.length-1);
        System.out.println("最终排序结果：");
        SortUtil.print(array);

    }
}
