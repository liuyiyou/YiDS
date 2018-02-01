package cn.liuyiyou.ds;

import cn.liuyiyou.ds.chapter04.tree.BinarySearchTree;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-22
 * Time: 下午11:42
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTreeTest {



    @Test
    public void testMakeEmpty() throws Exception {

        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();


    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(7);

       boolean result =  tree.contains(10);
       System.out.println(result);
    }

    @Test
    public void testFindMax() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(7);

        int max = tree.findMax();
        System.out.print(max);

    }

    @Test
    public void testFindMin() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(7);

        int min = tree.findMin();
        System.out.print(min);
    }



    @Test
    public void testHeight() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(7);
        tree.printTree();
    }

    @Test
    public void testRemove() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(7);

        tree.printTree();

        tree.remove(2);

        tree.printTree();

    }

    @Test
    public void testPrintTree() throws Exception {

    }
}
