package HUAWEI_2020;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();// n����
			int m = sc.nextInt();// m̨����
			int x = sc.nextInt();// ϴ����ʱ��
			int y = sc.nextInt();// �ӷ���ʱ��
			int[] time = new int[m];
			for (int j = 0; j < m; j++) {
				time[j] = sc.nextInt();
			}
			int result = sloution(n, m, x, y, time);
			System.out.println(result);
		}
	}

	private static int sloution(int n, int m, int x, int y, int[] time) {
		// ��i����Ҫ��ʱ��
		int[] dp = new int[n];
		// ��ǰ�����ǵڼ���
		int[] cup = new int[m];
		for (int i = 0; i < n; i++) {
			// �ҳ���ǰ��̨�������
			int minIndex = 0;
			for (int j = 0; j < m; j++) {
				if (time[minIndex] * (cup[minIndex] + 1) > time[j] * (cup[j] + 1)) {
					minIndex = j;
				}
			}
			dp[i] = time[minIndex] * (cup[minIndex] + 1);
			cup[minIndex] += 1;

		}
		//�ӷ�
		int res = 0;

		if (x >= y) {
			res = dp[n - 1] + y;// ϴ����̫������Ҷ���Ȼ�ӷ�
		} else {
			// �ӷ�̫����������ϴ���ӣ�ǰ����ûӷ�
			for (int i = n - 2; i >= 0; i--) {
				if (dp[i] + x > dp[i + 1]) {
					res = Math.max(res, dp[i] + y);
				}
			}
			//��ǰ���ܵ���Сʱ��
			res = dp[n - 1] + x;
			//
			int xiMax = 0;
			int index = 0;
			for(int i = 0;i<n;i++) {
				if(dp[i]+y>res) {
					xiMax = dp[i]+20;
					index = i;
				}
			}
			for(int i = index+1;i<n;i++) {
				if(dp[i]+y>xiMax) {
					
				}
			}
		}
		return res;
	}
}
