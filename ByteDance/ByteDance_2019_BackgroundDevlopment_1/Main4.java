package ByteDance_2019_BackgroundDevlopment_1;

import java.util.Scanner;

/*
	第四题:
		有N根绳子，第i根长为Li，现需要m根等长绳子。
		你可以对n根绳子进行任意剪裁(不能拼接)，计算出这m根绳子最长的长度多少?
 */
public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N根不等的绳子长度
		int N = sc.nextInt();
		// 裁剪成M跟等长的绳子
		int M = sc.nextInt();
		// N根绳子的长度
		int[] len = new int[N];

		// 总绳长
		int sum = 0;
		for (int i = 0; i < N; i++) {
			len[i] = sc.nextInt();
			sum += len[i];
		}
		sloution(len, M, N, sum);
	}

	// 二分法
	private static void sloution(int[] len, int M, int N, int sum) {
		double l = 0;
		double r = sum;
		double ans = 0;
		while (r - l > 1e-4) {
			double mid = (l + r) / 2;
			if (mid == 0) {
				break;
			}
			if (check(mid, N, len, M)) {
				l = mid;
				ans = mid;
			} else {
				r = mid;
			}
		}
		System.out.println(String.format("%.2f", ans));

	}

	// 判断是否能截成M段
	private static boolean check(double mid, int n, int[] a, int m) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.floor(a[i] / mid);
		}
		return sum >= m;
	}
}
