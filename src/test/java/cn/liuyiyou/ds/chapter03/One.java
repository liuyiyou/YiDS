package cn.liuyiyou.ds.chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class One {

	/**
	 * 打印L中那些由P所指定位置上的元素
	 * 
	 * @param L
	 * @param P
	 */
	public static <T> void printLots(List<T> L, List<Integer> P) {
		Iterator<T> iterL = L.iterator();
		Iterator<Integer> iterP = P.iterator();

		Integer itemP = 0;
		T itemL = null;
		int start = 0;

		while (iterL.hasNext() & iterP.hasNext()) {
			itemP = iterP.next();

			System.out.println("当前所在位置为：" + itemP);

			while (start < itemP && iterL.hasNext()) {
				itemL = iterL.next();
				start++;
			}

			System.out.println(itemL);
		}
	}

	@Test
	public void printLotsTest() {
		List<Integer> L = new ArrayList<Integer>();
		L.add(1);
		L.add(2);
		L.add(3);
		L.add(4);
		L.add(5);
		L.add(6);
		List<Integer> P = new ArrayList<Integer>();
		P.add(1);
		P.add(3);
		P.add(4);
		P.add(6);
		One.printLots(L, P);
	}

}
