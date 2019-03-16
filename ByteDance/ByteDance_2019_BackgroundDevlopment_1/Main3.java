package ByteDance_2019_BackgroundDevlopment_1;

import java.util.Scanner;

/*
	第三题:
		n个人参加比赛，结束后每个人一个分数。领奖时所有人排成一圈，第一个和第n个相邻。
		要求:
			1.如果某个人的分数比左右的人都要高，那么奖品数量也要比左右多。
			2.每个至少得一个奖品。问最少应该准备多少个奖品?

 */
public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();// 比赛人数
			int[] a = new int[num + 1];// 分数
			int[] p = new int[num + 1];
			for (int j = 0; j < num; j++) {
				a[j] = sc.nextInt();
				p[j] = 1;
			}
			// 首尾相连
			a[num] = a[0];
			p[num] = 1;
			sloution(num, a, p);
		}

	}

	private static void sloution(int num, int[] a, int[] p) {
		while (true) {
			boolean flag = false;// 数据发生变化
			for (int i = 0; i < num; i++) {
				// 左边的人分数低，奖励多的情况，更新右边的奖励
				if (a[i] < a[i + 1] && p[i] >= p[i + 1]) {
					p[i + 1] = p[i] + 1;
					flag = true;
				}
			}
			p[0] = p[num];

			for (int i = num; i > 0; i--) {
				// 左边的人分数高，奖励少的情况，更新左边的奖励
				if (a[i - 1] > a[i] && p[i - 1] <= p[i]) {
					p[i - 1] = p[i] + 1;
					flag = true;
				}
			}
			p[num] = p[0];
			// 数据不发生变化时结束循环
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
