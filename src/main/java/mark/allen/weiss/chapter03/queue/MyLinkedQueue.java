package mark.allen.weiss.chapter03.queue;

import mark.allen.weiss.chapter03.list.MyLinkedList;

public class MyLinkedQueue<T> implements MyQueue<T> {

	private MyLinkedList<T> theItems;

	public MyLinkedQueue() {
		theItems = new MyLinkedList<T>();
	}

	@Override
	public boolean isEmpty() {
		return theItems.isEmpty();
	}

	@Override
	public void enQueue(T t) {
		theItems.add(t);
	}

	@Override
	public T deQueue() {
		return theItems.remove(0);
	}

	@Override
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append("MyListQueue: [");
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
