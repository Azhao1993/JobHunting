package HUAWEI_2020;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();// n个人
			int m = sc.nextInt();// m台数据
			int x = sc.nextInt();// 洗杯子时间
			int y = sc.nextInt();// 挥发的时间
			int[] time = new int[m];
			for (int j = 0; j < m; j++) {
				time[j] = sc.nextInt();
			}
			int result = sloution(n, m, x, y, time);
			System.out.println(result);
		}
	}

	private static int sloution(int n, int m, int x, int y, int[] time) {
		// 第i杯需要的时间
		int[] dp = new int[n];
		// 当前机器是第几杯
		int[] cup = new int[m];
		for (int i = 0; i < n; i++) {
			// 找出当前哪台机器最快
			int minIndex = 0;
			for (int j = 0; j < m; j++) {
				if (time[minIndex] * (cup[minIndex] + 1) > time[j] * (cup[j] + 1)) {
					minIndex = j;
				}
			}
			dp[i] = time[minIndex] * (cup[minIndex] + 1);
			cup[minIndex] += 1;

		}
		//挥发
		int res = 0;

		if (x >= y) {
			res = dp[n - 1] + y;// 洗杯子太慢，大家都自然挥发
		} else {
			// 挥发太慢，最大的用洗杯子，前面的用挥发
			for (int i = n - 2; i >= 0; i--) {
				if (dp[i] + x > dp[i + 1]) {
					res = Math.max(res, dp[i] + y);
				}
			}
			//当前可能的最小时间
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
