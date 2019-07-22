package mark.allen.weiss.chapter03.list;

import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
	
	MyArrayList<Integer> list = new MyArrayList<Integer>();
	
	@Before
	public void setUp(){
		
		list.add(3);
		list.add(5);
		list.add(8);
		list.add(11);
		System.out.println("初始化列表为：");
		list.print(list);
	}
	
	@Test
	public void sizeTest(){
		System.out.println(list.size());
	}

	@Test
	public void addTest() {
		list.add(12);
		list.print(list);
	}
	
	
	@Test
	public void add2Test() {
		list.add(3, 12);
		list.print(list);
	}

}
