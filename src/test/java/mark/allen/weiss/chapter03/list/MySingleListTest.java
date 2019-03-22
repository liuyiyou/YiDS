package mark.allen.weiss.chapter03.list;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class MySingleListTest {

	private MySingleList<Integer> list = new MySingleList<Integer>();

	@Before
	public void setBefore() {
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
	}

	@Test
	public void fail() {
		System.out.println(list.get(0));
	}

	@Test
	public void sizeTest() {
		Assert.assertEquals(5, list.size());
	}

	@Test
	public void getNode() {
		System.out.println(list.get(0));
	}

	@Test
	public void emptyTest() {
		System.out.println(list.toString());
		Assert.assertFalse(list.isEmpty());
		int theSize = list.size();
		for (int i = 0; i < theSize; i++) {
			list.remove(0);
		}
		Assert.assertTrue(list.isEmpty());

	}

	@Test
	public void removeTest() {
		Integer data = list.remove(1);
		Assert.assertEquals(3 + "", data + "");
	}

	@Test
	public void removeObjTest() {
		Integer obj = 1;
		boolean result1 = list.remove(obj);
		Assert.assertTrue(result1);
		toStringTest();
		obj = 5;
		boolean result2 = list.remove(obj);
		Assert.assertTrue(result2);
		toStringTest();
		obj = 9;
		boolean result3 = list.remove(obj);
		Assert.assertTrue(result3);
		toStringTest();
		obj = 11;
		boolean result4 = list.remove(obj);
		Assert.assertFalse(result4);
		toStringTest();
	}

	@Test
	public void indexOfTest() {
		int index = -1;
		index = list.indexOf(1);
		Assert.assertEquals(0, index);
		
		index = list.indexOf(5);
		Assert.assertEquals(2, index);
		
		index = list.indexOf(9);
		Assert.assertEquals(4, index);
		
		index = list.indexOf(11);
		Assert.assertEquals(-1, index);
	}
	
	@Test
	public void lastIndexOfTest() {
		list.add(1, 5);
		toStringTest();
		
		int index = -1;
		index = list.indexOf(1);
		Assert.assertEquals(0, index);
		
		index = list.indexOf(5);
		Assert.assertEquals(1, index);
		
		index = list.lastIndexOf(5);
		Assert.assertEquals(3, index);
		
		index = list.indexOf(9);
		Assert.assertEquals(5, index);
		
		index = list.indexOf(11);
		Assert.assertEquals(-1, index);
	}
	
	

	@Test
	public void containsTest() {
		boolean isTrue = list.contains(5);
		Assert.assertTrue(isTrue);
		boolean isFalse = list.contains(11);
		Assert.assertFalse(isFalse);
	}

	@Test
	public void toStringTest() {
		System.out.println(list.toString());
	}
	
	@Test
	public void toArrayTest(){
		Object[] objs = list.toArray();
		Assert.assertEquals(list.size(), objs.length);
		for(Object obj:objs){
			System.out.print(obj.toString()+"\t");
		}
		System.out.println();
	}
}
