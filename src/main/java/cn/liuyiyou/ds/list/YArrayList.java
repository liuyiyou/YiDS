package cn.liuyiyou.ds.list;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/22
 * @version: V1.0
 */
public class YArrayList<T> implements YList<T> {


    //ADT
    private int size;
    private T[] items;

    public YArrayList() {
        items = (T[]) new Object[10];
        size = 0;
    }

    //method
    @Override
    public void clear() {
        items = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[index];
    }

    @Override
    public T set(int index, T item) {
        T oldItem = get(index);
        items[index] = item;
        return oldItem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(T t) {
        if (size >= items.length) {
            ensureCapacity();
        }
        items[size] = t;
        size++;
        return true;
    }

    private void ensureCapacity() {
        T[] newItems = (T[]) new Object[size * 2];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    @Override
    public T remove(int index) {
        T oldItem = get(index);
        /**
         * //为什么是i<size-1而不是size? ,如果是size，最后一个items[last] = items[last+1] 超过数组长度
         * <pre>
         *     for(int i = index; i< size - 1;i++){
         *          items[i] = items[i+1];
         *
         *     }
         * </pre>
         */
        System.arraycopy(items, index + 1, items, index, (size - 1) - index);
        size--;
        return oldItem;
    }

    @Override
    public void print() {

        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + "\t");
        }
        System.out.println();
    }
}
