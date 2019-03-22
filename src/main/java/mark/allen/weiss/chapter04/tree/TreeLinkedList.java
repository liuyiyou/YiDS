package mark.allen.weiss.chapter04.tree;

/**
 * Created with IntelliJ IDEA.
 * User: liuyiyou
 * Date: 14-7-8
 * Time: 下午7:39
 * To change this template use File | Settings | File Templates.
 */
public class  TreeLinkedList implements Tree {
    private Object element;
    private TreeLinkedList parent, firstChild, nextSibing;

    public TreeLinkedList() {
        this(null, null, null, null);
    }

    public TreeLinkedList(Object element, TreeLinkedList parent,
                          TreeLinkedList firstChild, TreeLinkedList nextSibing) {
        super();
        this.element = element;
        this.parent = parent;
        this.firstChild = firstChild;
        this.nextSibing = nextSibing;
    }

    @Override
    public Object getElem() {
        return element;
    }

    public Object setElem(Object obj) {
        Object bak = element;
        element = obj;
        return bak;
    }

    @Override
    public int getDepth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TreeLinkedList getFirstChild() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TreeLinkedList getNextSibling() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TreeLinkedList getParent() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

}
