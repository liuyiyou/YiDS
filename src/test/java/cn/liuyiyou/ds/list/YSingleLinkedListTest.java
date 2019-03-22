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
public class YSingleLinkedListTest {

    private YSingleLinkedList<Integer> linkedList;

    @Before
    public void before() {
        linkedList = new YSingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.println("初始化列表::");
        linkedList.print();
        System.out.println("列表长度::" + linkedList.size());
    }

    @After
    public void after() {
        System.out.println("执行方法后::");
        linkedList.print();
        System.out.println("列表长度::" + linkedList.size());
    }

    @Test
    public void clear() {
        linkedList.clear();
        Assert.assertTrue(linkedList.isEmpty());
        linkedList.add(1);
    }

    @Test
    public void get() {
        Assert.assertEquals(new Integer(1), linkedList.get(1));
    }

    @Test
    public void set() {
        Assert.assertEquals(new Integer(1), linkedList.set(1, 10));
        Assert.assertEquals(new Integer(10), linkedList.get(1));
    }

    @Test
    public void size() {
        Assert.assertEquals(10, linkedList.size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(!linkedList.isEmpty());
    }

    @Test
    public void add() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(linkedList.get(i) * 2);
        }
    }

    @Test
    public void remove() {
        linkedList.remove(0);
        Assert.assertEquals(9, linkedList.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeFail() {
        linkedList.remove(11);
    }

    @Test
    public void print() {
    }
}