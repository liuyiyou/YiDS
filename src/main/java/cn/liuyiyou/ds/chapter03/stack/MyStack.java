package cn.liuyiyou.ds.chapter03.stack;

public interface MyStack<T> {
	/**
	 * 判断栈是否为空
	 */
	boolean isEmpty();
	/**
	 * 清空栈
	 */
	void clear();
	/**
	 * 栈的长度
	 */
	int size();
	/**
	 * 数据入栈
	 */
	boolean push(T data);
	/**
	 * 数据出栈
	 */
	T pop();
	
	String print();
}