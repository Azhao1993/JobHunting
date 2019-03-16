package ByteDance_2019_houduan;

import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		double[] len = new double[N];
		for (int i = 0; i < N; i++) {
			len[i] = sc.nextInt() * 100;
		}
		sloution(len, M, N);
	}

	private static void sloution(double[] len, int M, int N) {
		int l = 0;
		int r = 1000000000;
		int ans = 0;
		while (l <= r) {
			int mid = (l + r )>> 1;
			if (mid == 0) {
				break;
			}
			if (pd(mid, N, len, M)) {
				l = mid + 1;
				ans = mid;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(String.format("%.2f", (double) (ans / 100)));

	}

	private static boolean pd(int mid, int n, double[] a, int m) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			sum += a[i] / mid;
		}
		return sum >= m;
	}
}
