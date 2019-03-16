package ByteDance_2019_BackgroundDevelopment_1;

import java.util.Scanner;

/*
	������:
		��N�����ӣ���i����ΪLi������Ҫm���ȳ����ӡ�
		����Զ�n�����ӽ����������(����ƴ��)���������m��������ĳ��ȶ���?
 */
public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N�����ȵ����ӳ���
		int N = sc.nextInt();
		// �ü���M���ȳ�������
		int M = sc.nextInt();
		// N�����ӵĳ���
		int[] len = new int[N];

		// ������
		int sum = 0;
		for (int i = 0; i < N; i++) {
			len[i] = sc.nextInt();
			sum += len[i];
		}
		sloution(len, M, N, sum);
	}

	// ���ַ�
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

	// �ж��Ƿ��ܽس�M��
	private static boolean check(double mid, int n, int[] a, int m) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.floor(a[i] / mid);
		}
		return sum >= m;
	}
}
