package cn.liuyiyou.ds.chapter03.stack;

import cn.liuyiyou.ds.chapter03.list.MyArrayList;

public class MyArrayStack<T> implements MyStack<T> {

	private MyArrayList<T> theItems = null;

	public MyArrayStack() {
		theItems = new MyArrayList<T>();
	}

	@Override
	public boolean isEmpty() {
		return theItems.isEmpty();
	}

	@Override
	public void clear() {
		theItems.clear();
	}

	@Override
	public int size() {
		return theItems.size();
	}

	@Override
	public boolean push(T data) {
		theItems.add(0, data);
		return true;
	}

	@Override
	public T pop() {
		return theItems.remove(0);
	}

	@Override
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append("MyArrayStack: [");
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
