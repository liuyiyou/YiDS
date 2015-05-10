package cn.liuyiyou.ds.chapter03.queue;

import org.junit.Before;
import org.junit.Test;

public class MyArrayQueueTest {

	private MyArrayQueue<Integer> queue;

	@Before
	public void setUp() {
		queue = new MyArrayQueue<Integer>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		
		System.out.println(queue.print());
	}

	@Test
	public void enQueueTest() {
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		
		System.out.println(queue.print());
	}

	@Test
	public void deQueueTest() {

		boolean result = true;
		while (result) {
			if (!queue.isEmpty()) {
				System.out.println(queue.deQueue());
			} else {
				result = false;
			}

		}

	
	}
}
