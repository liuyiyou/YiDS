package mark.allen.weiss.chapter03.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个表L和另一个表P，他们包含升序排列的整数，操作printLots(L,P)将打印L中那些由P所指定的位置上的元素。例如，如果P=1，3，4，6
 * 那么，L中位于第1、3、4、6位置上的元素被打印出来。 可以使用Collections中的api进行操作。该过程运行时间是多少
 * 
 * @author liuyiyou
 *
 */
public class PrintLos {

	public static void printLots(List<Integer> L, List<Integer> P) {
		for (Integer p : P) {
			if (L.size() < p) {
				System.out.println("该位置没有元素，因为是升序排序，后面的不再执行");
				break;
			}
			System.out.println(L.get(p));
		}
	}

	public static void main(String[] args) {
		List<Integer> P = new ArrayList<Integer>();
		P.add(1);
		P.add(3);
		P.add(4);
		P.add(6);
		P.add(11);

		List<Integer> L = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			L.add(i);
		}

		PrintLos.printLots(L, P);
	}
}
