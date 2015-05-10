package cn.liuyiyou.ds.chapter03.queue;

import cn.liuyiyou.ds.chapter03.list.MyArrayList;

public class MyArrayQueue<T> implements MyQueue<T>{
	
	private MyArrayList<T> theItems;
	
	public MyArrayQueue() {
		theItems = new MyArrayList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		return theItems.isEmpty();
	}

	@Override
	public void enQueue(T t) {
		theItems.add(theItems.size(), t);
	}

	@Override
	public T deQueue() {
		return theItems.remove(0);
	}
	
	@Override
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append("MyArrayQueue: [");
		for (int i = 0; i < theItems.size(); i++) {
			sb.append(theItems.get(i).toString());
			if (i != theItems.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	

}
