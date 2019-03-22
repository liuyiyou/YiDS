package mark.allen.weiss.three;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String A = "";
		String B = "";
		while (input.hasNext()) {
			String str = input.nextLine();
			String[] sA = str.substring(0, str.length() - 1).split("\\+");
			String a = sA[0].trim();
			String b = sA[1].trim();
			if (a.split(" ").length == 2) {
				String a1 = a.split(" ")[0].trim();
				String a2 = a.split(" ")[1].trim();
				A = Main.enToNum(a1) + "" + Main.enToNum(a2);
			} else {
				A = Main.enToNum(a) + "";
			}
			if (b.split(" ").length == 2) {
				String b1 = b.split(" ")[0].trim();
				String b2 = b.split(" ")[1].trim();
				B = Main.enToNum(b1) + "" + Main.enToNum(b2);
			} else {
				B = Main.enToNum(b) + "";
			}
			int result = Integer.parseInt(A) + Integer.parseInt(B);
			if (result == 0) {

			} else {
				System.out.println(result);
			}

		}

	}

	public static Integer enToNum(String str) {
		String numstr[] = { "zero", "one", "two", "three", "four", "five",
				"six", "seven", "eight", "nine" };
		String num[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		for (int i = 0; i < num.length; i++) {
			
		}

		return 0;
	}
}
