package cn.liuyiyou.ds.chapter04.tree;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-8
 * Time: 下午7:39
 * To change this template use File | Settings | File Templates.
 */
 interface Tree {


    // 返回当前节点中存放的对象
     Object getElem();

    // 返回当前节点的父节点
     TreeLinkedList getParent();

    // 返回当前节点的长子
     TreeLinkedList getFirstChild();

    // 返回当前节点的最大弟弟
     TreeLinkedList getNextSibling();

    // 返回当前节点的后代元素的数目，即以当前节点为根节点的子树的规模
     int getSize();

    // 返回当前节点的高度
     int getDepth();
}
