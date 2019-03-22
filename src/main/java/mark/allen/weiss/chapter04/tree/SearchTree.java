package mark.allen.weiss.chapter04.tree;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-22
 * Time: 下午11:32
 * To change this template use File | Settings | File Templates.
 */

public interface SearchTree<T extends Comparable<? super T>> {

    //使tree为空
    void makeEmpty();

    //判断是否为空
    boolean isEmpty();


    //判断是否包含某个元素
    boolean contains(T t);

    //得到最大的元素
    T findMax();

    //得到最小的元素
    T findMin();

    //树的高度
    int height();

    //插入
    void insert(T x);

    //删除
    void remove(T x);


    //打印树
    void printTree();
}
