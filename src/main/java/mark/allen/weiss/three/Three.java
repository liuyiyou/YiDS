package mark.allen.weiss.three;

/**
 * 题目描述：
 给定两个整数A和B，其表示形式是：从个位开始，每三位数用逗号","隔开。
 现在请计算A+B的结果，并以正常形式输出。
 输入：
 输入包含多组数据数据，每组数据占一行，由两个整数A和B组成（-10^9 < A,B < 10^9）。
 输出：
 请计算A+B的结果，并以正常形式输出，每组数据占一行。
 样例输入：
 -234,567,890 123,456,789
 1,234 2,345,678
 样例输出：
 -111111101
 2346912

 */

import java.math.BigInteger;
import java.util.Scanner;

public class Three {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String s = input.nextLine();
			String[] sA = s.split(" ");
			System.out.println(Integer.valueOf(sA[0].replace(",", ""))
					+ Integer.valueOf(sA[1].replace(",", "")));

		}
	}

//	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		while (input.hasNext()) {
//			String s = input.nextLine();
//			String[] sA = s.split(" ");
//			System.out.println(new BigInteger(sA[0].replace(",", ""))
//					.add(new BigInteger(sA[1].replace(",", ""))));
//
//		}
//
//	}
//
//	public static void main(String[] args) {
//		Scanner input = new Scanner(new BufferedInputStream(System.in));
//		while (input.hasNext()) {
//			String s = input.nextLine();
//			String[] sA = s.split(" ");
//			System.out.println(new BigInteger(sA[0].replace(",", ""))
//					.add(new BigInteger(sA[1].replace(",", ""))));
//
//		}
//
//	}

}
