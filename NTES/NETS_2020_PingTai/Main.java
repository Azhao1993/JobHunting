
package NETS;

import java.util.Scanner;
/*
5
6 5
4 3 0 42
10 6
5 3 1 46
5 5
3 3 1 7
5 5
3 3 1 6
7 7
4 5 2 9


35
22
8
6
5

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();// q�����Ե�
		for (int i = 0; i < q; i++) {
			int n = sc.nextInt();// n��
			int m = sc.nextInt();// m��
			int x = sc.nextInt();// ���Ժ�����
			int y = sc.nextInt();// ��ʼ�����
			int w = sc.nextInt();// �˶�����
			int t = sc.nextInt();// �뿪��ʱ��
			int[] res = { 0 };
			sloution(n, m, x, y, w, t, res);
			System.out.println(res[0]);
		}
	}

	private static void sloution(int n, int m, int x, int y, int w, int t, int[] res) {
		// 0:���ϣ�1�����ϣ�2�����£�3������
		// �����˶�����ǽ���������˶����������
		// �ϻ����£��������
		int stepx = 0, stepy = 0;
		while (t > 0) {
			// ��Ҫ�˶��Ĵ���
			switch (w) {
			// ���Ϸ���
			case 0:
				stepx = y - 1;
				stepy = x - 1;
				if (stepx == stepy) {
					// ײ�� 1, 1
					t -= stepx;
					if (t >= 0)
						res[0] += 2;
					w = 2;
					x = 1;
					y = 1;
				} else if (stepx > stepy) {
					// ײ���ϱ�
					t -= stepy;
					if (t >= 0)
						res[0]++;
					x = 1;
					y = y - stepy;
					w = 3;
				} else {
					// ײ�������
					t -= stepx;
					if (t >= 0)
						res[0]++;
					y = 1;
					x = x - stepx;
					w = 1;
				}
				break;
			case 1:
				// ����
				stepx = m - y;// ���ҵĲ���
				stepy = x - 1;// ���ϵĲ���
				if (stepx == stepy) {
					t -= stepx;
					if (t >= 0)
						res[0] += 2;
					w = 3;
					x = 1;
					y = m - 1;
				} else if (stepx > stepy) {
					// ײ���ұ�
					t -= stepy;
					if (t >= 0)
						res[0]++;
					y = m - 1;
					x = x - stepy;
					w = 0;
				} else {
					// ײ�����ϱ�
					t -= stepx;
					if (t >= 0)
						res[0]++;
					x = 1;
					y = y + stepx;
					w = 2;
				}
				break;
			case 2:
				// ����
				stepx = m - y;// ���ҵĲ���
				stepy = n - x;// ���µĲ���
				if (stepx == stepy) {
					t -= stepx;
					if (t >= 0)
						res[0] += 2;
					w = 0;
					x = n - 1;
					y = m - 1;
				} else if (stepx > stepy) {
					// ײ���ұ�
					t -= stepy;
					if (t >= 0)
						res[0]++;
					x = x + stepy;
					y = m - 1;
					w = 3;
				} else {
					// ײ�����±�
					t -= stepx;
					if (t >= 0)
						res[0]++;
					x = n - 1;
					y = y + stepx;
					w = 1;
				}
				break;
			case 3:
				// ����
				stepx = y - 1;// ����Ĳ���
				stepy = n - x;// ���µĲ���
				if (stepx == stepy) {
					t -= stepx;
					if (t >= 0)
						res[0] += 2;
					w = 1;
					x = n - 1;
					y = 1;
				} else if (stepx > stepy) {
					// ײ�����
					t -= stepy;
					if (t >= 0)
						res[0]++;
					x = x + stepy;
					y = 1;
					w = 2;
				} else {
					// ײ�����±�
					t -= stepx;
					if (t >= 0)
						res[0]++;
					x = n - 1;
					y = y - stepx;
					w = 0;
				}
				break;
			}
		}
	}
}