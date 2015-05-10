package cn.liuyiyou.ds.chapter03;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import cn.liuyiyou.ds.chapter03.list.MyLinkedList;

/**
 * 通过调整链（而不是数据）来交换两个相邻的元素，使用
 * a. 单链表
 * b. 双链表
 * @author liuyiyou
 *
 */
public class Two {

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
	
	//出错了
	@Test
	public void swap1Test(){
		list.swapWithNext1(list.getNode(1));
		System.out.println("交换顺序之后的列表为：");
		list.print(list);
	}
	
	@Test
	public void swap2Test(){
		list.swapWithNext2(list.getNode(1));
		System.out.println("交换顺序之后的列表为：");
		list.print(list);
	}
}
