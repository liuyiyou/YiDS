package cn.liuyiyou.ds.chapter03.list;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
	
	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
//	
//	@Before
//	public void setUp(){
//		
//		list.add(3);
//		list.add(5);
//		list.add(8);
//		list.add(11);
//		System.out.println("初始化列表为：");
//		list.print(list);
//	}
	
	@Test
	public void sizeTest(){
		System.out.println(list.size());
		System.out.println(list.get(0));
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
		System.out.println(list.get(2));
		list.remove(2);
		list.print(list);
	}
	
	@Test
	public void test(){
		List<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(5);
		list.add(8);
		list.add(11);
		System.out.println(list.get(0));
	}

}
