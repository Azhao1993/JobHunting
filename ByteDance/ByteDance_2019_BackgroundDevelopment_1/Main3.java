package ByteDance_2019_BackgroundDevelopment_1;

import java.util.Scanner;

/*
	������:
		n���˲μӱ�����������ÿ����һ���������콱ʱ�������ų�һȦ����һ���͵�n�����ڡ�
		Ҫ��:
			1.���ĳ���˵ķ��������ҵ��˶�Ҫ�ߣ���ô��Ʒ����ҲҪ�����Ҷࡣ
			2.ÿ�����ٵ�һ����Ʒ��������Ӧ��׼�����ٸ���Ʒ?

 */
public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();// ��������
			int[] a = new int[num + 1];// ����
			int[] p = new int[num + 1];
			for (int j = 0; j < num; j++) {
				a[j] = sc.nextInt();
				p[j] = 1;
			}
			// ��β����
			a[num] = a[0];
			p[num] = 1;
			sloution(num, a, p);
		}

	}

	private static void sloution(int num, int[] a, int[] p) {
		while (true) {
			boolean flag = false;// ���ݷ����仯
			for (int i = 0; i < num; i++) {
				// ��ߵ��˷����ͣ������������������ұߵĽ���
				if (a[i] < a[i + 1] && p[i] >= p[i + 1]) {
					p[i + 1] = p[i] + 1;
					flag = true;
				}
			}
			p[0] = p[num];

			for (int i = num; i > 0; i--) {
				// ��ߵ��˷����ߣ������ٵ������������ߵĽ���
				if (a[i - 1] > a[i] && p[i - 1] <= p[i]) {
					p[i - 1] = p[i] + 1;
					flag = true;
				}
			}
			p[num] = p[0];
			// ���ݲ������仯ʱ����ѭ��
			if (!flag)
				break;

		}
		long ans = 0;
		for (int i = 0; i < num; i++) {
			ans += p[i];
		}
		System.out.println(ans);

	}
}
