package cn.liuyiyou.ds.list;

import org.junit.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/22
 * @version: V1.0
 */
public class SystemArrayCopyTest {

    /**
     * 　Object src : 原数组
     * int srcPos : 从元数据的起始位置开始
     * 　　Object dest : 目标数组
     * 　　int destPos : 目标数组的开始起始位置
     * 　　int length  : 要copy的数组的长度
     */
    @Test
    public void copy() {
        int[] src = new int[]{1, 2, 3, 4, 5};
        int[] dest = new int[5];

        print(dest);
        //将2、3 复制到目标数组树种
        System.arraycopy(src, 1, dest, 0, 3);
        print(dest);
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
