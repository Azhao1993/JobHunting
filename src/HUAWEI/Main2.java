package HUAWEI;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// ×Ö·û´®µÄ¸öÊý
		sc.nextLine();
		String cur = sc.nextLine();
		for (int i = 0; i < N; i++) {
			char m = cur.charAt(i * 9);
			StringBuilder temp = new StringBuilder(cur.substring(i * 9 + 1, i * 9 + 9));
			slution(temp, m);
			if (i != N - 1) {
				System.out.print(" ");
			}

		}

	}

	private static void slution(StringBuilder temp, char m) {
		if (m == '1') {
			System.out.print(temp.toString());
		} else {
			System.out.print(temp.reverse().toString());
		}

	}
}
