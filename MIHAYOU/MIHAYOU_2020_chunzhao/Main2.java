package MIHAYOU_2020_chunzhao;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
	// java.lang.OutOfMemoryError
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// N����
		int[] x = new int[N];
		int[] y = new int[N];
		int[] len = new int[N];
		// ���ֵ
		int m = 0;
		int n = 0;
		for (int i = 0; i < N; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			len[i] = sc.nextInt();
			m = Math.max(m, x[i] + len[i]);
			n = Math.max(n, y[i] + len[i]);
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			int dx = x[i];
			int dy = y[i];
			for (int xx = 0; m < len[i]; m++) {
				for (int yy = 0; n < len[i]; n++) {
					// ��άתһά
					int one = (dx + xx) * n + dy + yy;
					set.add(one);
				}
			}
		}
		System.out.println(set.size());

	}

}
