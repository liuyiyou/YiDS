package cn.liuyiyou.ds.chapter03.list;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-24
 * Time: 上午3:41
 * To change this template use File | Settings | File Templates.
 */
public interface List<T>{

    java.util.ArrayList

    void clear();

    int size();

    boolean  isEmpty();

    boolean add(T t);

    T remove(int index);


}
