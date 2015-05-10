package cn.liuyiyou.ds;

/**
 * 一般习惯称之为费氏数列,例 如以下: 1、1 、2、3、5、8、13、21、34、55、89...... 解法： fn = fn-1 + fn-2 fn
 * = n
 * 
 * @author liuyiyou
 *
 */
public class FibonacciTest {

	long t = 1;
	Long t1 = 1l;

	/**
	 * 这不是斐波拉斯，是阶乘
	 * @param n
	 * @return
	 */
	public static long factoial(int n) {
		if (n <= 1)
			return 1;
		else
			return n * factoial(n - 1);
	}

	public static long fib(int n) {
		if (n <= 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		fib(40);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		start = System.currentTimeMillis();
		factoial(40);
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
