package mark.allen.weiss.chapter03.list.copy;

import mark.allen.weiss.chapter03.list.MyLinkedList;
import org.junit.Before;
import org.junit.Test;


public class MyLinkedListTest {

	MyLinkedList<Integer> list = new MyLinkedList<Integer>();

	@Before
	public void setUp() {

		list.add(3);
		list.add(5);
		list.add(8);
		list.add(11);
		System.out.println("初始化列表为：");
		list.print(list);
	}
	
	@Test
	public void clearTest(){
		list.clear();
	}

	@Test
	public void sizeTest() {
		System.out.println(list.size());
	}

	@Test
	public void addTest() {
		list.add(12);
		list.print(list);
	}

	

}
