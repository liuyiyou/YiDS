package cn.liuyiyou.ds.list;


/**
 * @author: liuyiyou.cn
 * @date: 2019/3/22
 * @version: V1.0
 */
public interface YList<T> {


    void clear();

    int size();

    boolean isEmpty();

    boolean add(T t);

    T remove(int index);

    T get(int index);

    T set(int index,T item);

    void print();

}
