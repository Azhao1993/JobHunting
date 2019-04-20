package Nets;

import java.util.Scanner;

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
		int stepx = 0, stepy = 0;
		while (t > 0) {
			// ��Ҫ�˶��Ĵ���
			switch (w) {

			// ����
			case 0:
				stepx = y - 2;// ����Ĳ���
				stepy = x - 2;// ���ϵĲ���

				if (stepx == stepy) {
					// ײ�����Ͻ�
					t -= stepx;
					if (t >= 0)
						res[0] += 2;
					// ��ʼ��λ��
					x = 2;
					y = 2;
					w = 2;// ����������2
				} else if (stepx > stepy) {
					// ײ���ϱ�
					t -= stepy;
					if (t >= 0)
						res[0]++;
					x = 2;
					y = y - stepy;
					w = 3;// ����������3
				} else {
					// ײ�����
					t -= stepx;
					if (t >= 0)
						res[0]++;
					y = 2;
					x = x - stepx;
					w = 1;// ����������1
				}
				break;

			// ����
			case 1:
				stepx = m - 1 - y;// ���ҵĲ���
				stepy = x - 2;// ���ϵĲ���
				if (stepx == stepy) {
					// ײ�����Ͻ�
					t -= stepx;
					if (t >= 0)
						res[0] += 2;
					x = 2;
					y = m - 1;
					w = 3;// �����Ϊ����
				} else if (stepx > stepy) {
					// ײ���ϱ�
					t -= stepy;
					if (t >= 0)
						res[0]++;
					x = 2;
					y += stepy;
					w = 2;
				} else {
					// ײ���ұ�
					t -= stepx;
					if (t >= 0)
						res[0]++;
					x -= stepx;
					y = m - 1;
					w = 0;
				}
				break;

			// ����
			case 2:
				stepx = m - 1 - y;// ���ҵĲ���
				stepy = n - 1 - x;// ���µĲ���
				if (stepx == stepy) {
					t -= stepx;
					if (t >= 0)
						res[0] += 2;
					w = 0;
					x = n - 1;
					y = m - 1;
				} else if (stepx > stepy) {
					// ײ���±�(�˶�)
					t -= stepy;
					if (t >= 0)
						res[0]++;
					x = n - 1;
					y = y + stepy;
					w = 1;
				} else {
					// ײ���ұ�(�˶�)
					t -= stepx;
					if (t >= 0)
						res[0]++;
					x = x + stepx;
					y = m - 1;
					w = 3;
				}
				break;

			// ����
			case 3:
				stepx = y - 2;// ����Ĳ���
				stepy = n - 1 - x;// ���µĲ���
				if (stepx == stepy) {
					// ���½ǣ��ԣ�
					t -= stepx;
					if (t >= 0)
						res[0] += 2;
					w = 1;
					x = n - 1;
					y = 2;
				} else if (stepx > stepy) {
					// ײ���±�(�˶�)
					t -= stepy;
					if (t >= 0)
						res[0]++;
					x = n - 1;
					y = y - stepy;
					w = 0;
				} else {
					// ײ�����(�˶�)
					t -= stepx;
					if (t >= 0)
						res[0]++;
					x = x + stepx;
					y = 2;
					w = 2;
				}
				break;
			}
		}
	}
}