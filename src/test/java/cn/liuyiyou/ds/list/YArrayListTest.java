package cn.liuyiyou.ds.list;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/22
 * @version: V1.0
 */
public class YArrayListTest {


    private YArrayList<Integer> arrayList;

    @Before
    public void before() {
        arrayList = new YArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println("初始化列表::" + arrayList.size());
        arrayList.print();
        System.out.println("列表长度::" + arrayList.size());
    }

    @After
    public void after() {
        arrayList.print();
        System.out.println("列表长度::" + arrayList.size());
    }

    @Test
    public void clear() {
        arrayList.clear();
        Assert.assertTrue(arrayList.isEmpty());
        arrayList.add(1);
    }

    @Test
    public void get() {
        Assert.assertEquals(new Integer(1), arrayList.get(1));
    }

    @Test
    public void set() {
        Assert.assertEquals(new Integer(1), arrayList.set(1, 10));
        Assert.assertEquals(new Integer(10), arrayList.get(1));
    }

    @Test
    public void size() {
        Assert.assertEquals(10, arrayList.size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(!arrayList.isEmpty());
    }

    @Test
    public void add() {
        for (int i = 0; i < 10; i++) {
            arrayList.add(arrayList.get(i) * 2);
        }
    }

    @Test
    public void remove() {
        arrayList.remove(3);
        Assert.assertEquals(9, arrayList.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeFail() {
        arrayList.remove(11);
    }

    @Test
    public void print() {
    }
}