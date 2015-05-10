package cn.liuyiyou.ds.chapter03;

import org.junit.Before;
import org.junit.Test;

import cn.liuyiyou.ds.chapter03.list.MyLinkedList;

/**
 * 实现MyLinkedList的contains方法
 * @author liuyiyou
 *
 */
public class Three {
	
	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
	
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
	public void containsTest(){
		System.out.println(list.contains(3));
		System.out.println(list.contains(34));
	}

}
