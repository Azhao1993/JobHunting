package FastSHow_2020_spring;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(",");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);

		int res = change(a, b);
		System.out.println(res);
	}

	public static int change(int a, int b) {
		if (a < -102 || a > 102) {
			return Integer.MAX_VALUE;
		}
		if (a > b) {
			return a - b;
		} else if (a == b) {
			return 0;
		} else {
			return 1 + Math.min(change(a + 1, b), a <= 0 ? Integer.MAX_VALUE : change(a * 2, b));
		}
	}
}
