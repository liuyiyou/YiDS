package mark.allen.weiss.chapter03.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {

    // 默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    // 列表大小
    private int theSize;

    // 列表元素
    private T[] theItems;

    /**
     * 构造函数：默认为空的列表
     */
    public MyArrayList() {
        clear();
    }

    /**
     * 清除列表数据
     */
    public void clear() {
        // 长度为0
        theSize = 0;
        // 默认大小
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * 列表大小
     *
     * @return
     */
    public int size() {
        return theSize;
    }

    /**
     * 列表是否为空
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 得到在index位置的数据
     *
     * @param index
     * @return
     */
    public T get(int index) {
        // 如果索引小于0或者索引大于等于列表大小，则抛出异常
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    /**
     * 设置列表在index位置的数据
     *
     * @param index
     * @param t
     * @return：原来index位置的数据
     */
    public T set(int index, T t) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // 原来在该位置的数据
        T old = theItems[index];
        // 将新的数据放到该位置
        theItems[index] = t;
        return old;
    }

    /**
     * 增加：一般是在末尾添加
     *
     * @param t
     * @return
     */
    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    /**
     * 在指定位置添加元素，通过扩容手段
     *
     * @param index
     * @param t
     */
    public void add(int index, T t) {
        rangeCheckForAdd(index);
        // 列表已满
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        // 从index+1处向后移动
        for (int i = theSize; i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        // 替换
        theItems[index] = t;
        theSize++;
    }

    private void rangeCheckForAdd(int index) {
        if (index > theSize || index < 0)
            throw new IndexOutOfBoundsException("数组越界");
    }

    public T remove(int index) {
        T old = theItems[index];
        // 从index开始，后面的向前移动
        for (int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return old;
    }

    /**
     * 列表扩容
     */
    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * 扩容
     *
     * @param newCapacity ：
     */
    public void ensureCapacity(int newCapacity) {
        // 如果需要的列表大小小于列表大小
        if (newCapacity < theSize)
            return;
        T[] old = theItems;
        // 不能使用new T，因为泛型不支持new
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    public void print(MyArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();

    }

    public String toString() {
        for (int i = 0; i < theItems.length; i++) {
            System.out.print(theItems[i] + "\t");
        }
        System.out.println();

        return null;
    }


    /**
     * 存储当前位置。程序在next方法中试图使用当前位置对下表访问数组元素，然后将当前位置向后推进
     *
     * @author liuyiyou
     */
    private class ArrayListIterator implements Iterator<T> {

        // 当前位置
        private int current = 0;

        /**
         * 是否有下一个：如果当前数据小于列表大小，则返回true，否则返回false
         */
        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            // 如果没有下一个，则直接抛出异常
            if (!hasNext())
                throw new NoSuchElementException();
            // 返回当前元素的下一个元素
            return theItems[current++];
        }

        /**
         * 删除，？？
         */
        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

    }


}
