package cn.liuyiyou.ds.chapter03.list;

import java.util.Collection;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-24
 * Time: 上午3:43
 * To change this template use File | Settings | File Templates.
 */
public class ArrayList <T extends Comparable<? super T>> implements List<T> {

    private T[] element;
    private int DEFUALT_SZIE = 10;
    private int size;



    @Override
    public void clear() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int size() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEmpty() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean add(T t) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T remove(int index) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
