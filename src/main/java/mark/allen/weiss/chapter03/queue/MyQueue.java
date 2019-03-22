package mark.allen.weiss.chapter03.queue;

public interface MyQueue<T> {
	
	boolean isEmpty() ;

	/**
	 * 入队列
	 * @param t
	 */
	void enQueue(T t);
	
	/**
	 * 出队列
	 * @param t
	 */
	 T deQueue();
	 
	 /**
	  * 输出
	  * @return
	  */
	 String print();
}
