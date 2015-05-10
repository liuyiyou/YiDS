package cn.liuyiyou.ds;

import java.util.Scanner;

/**
 * 如果柱子标为ABC,要由A搬至C,在只有一个盘子时,就将它直接搬至C,当有两个盘
 * 子,就将B当作辅助柱。如果盘数超过2个,将第三个以下的盘子遮起来,就很简单了,每次处 理两个盘子,也就是:A->B、A
 * ->C、B->C这三个步骤,而被遮住的部份,其实就是进入程式 的递回处理。事实上,若有n个盘子,则移动完毕所需之次数为2^n -
 * 1,所以当盘数为64时,则 所需次数为: 264- 1 = 18446744073709551615为5.05390248594782e+16年,也就是约
 * 5000世纪, 如果对这数字没什幺概念,就假设每秒钟搬一个盘子好了,也要约5850亿年左右。
 * 
 * @author liuyiyou
 *
 */
public class HanoiTest {
	
	public static void hanoi(int n, char a, char b,char c){
		if(n==1){
			System.out.printf("Move sheet %d from %c to %c\n",n,a,c);
		}else{
			hanoi(n-1, a, c, b);
			System.out.printf("Move sheet %d from %c to %c\n",n,a,c);
			hanoi(n-1, b, a, c);
		}
	}
	
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		hanoi(n, 'A', 'B', 'C');
	}

}
