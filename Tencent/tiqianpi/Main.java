package tiqianpi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int m = sc.nextInt();
			sloution(n, s, m);
		}
	}

	private static void sloution(int n, int s, int m) {
		// n����
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		// ��s���˿�ʼ����
		while (list.size() != 0) {
			System.out.println(list.remove((s + m - 2) % list.size()));
			s=(s+m-2)% list.size();
		}

	}

}
