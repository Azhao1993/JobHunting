package Alibaba;

/*
������һ��������Ϸ��һ����˵����һ��n��n�еķ���,
ÿ��λ�ö���һ�����������Ҹ߶Ȳ�ͬ�ķ��飬�߶�����֪�ģ�
��������ȥ֮������Լ�����������ÿ������������ٶ���ÿ1��λʱ��������1��λ�߶ȣ�
Ҫ������������ٶȴ�(0,0)����(n-1,n-1)�ķ��飬
��һ��������Ծ������һ�����飬ֻ���ڸ߶���ͬ���ߴӸߵ����͵��ƶ���
���һ������ĸ߶ȱ���Χ�ĵͣ�
��ô��Ҫ�ȴ�����߶�����Χ��������һ����ͬʱ�����ƶ��������ȴ������ʱ��
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {

	/** ������������������ʵ����ĿҪ��Ĺ��� **/
	/** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^ **/
	static int dump(int[][] grid) {
		int n = grid.length;
		// dp[i][j]��ʾ��i,j������Ҫ��ʱ��
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					dp[0][0] = 0;
				} else if (i == 0) {
					if (grid[i][j] > grid[i][j - 1]) {
						dp[i][j] = grid[i][j] - grid[i][j - 1] + dp[i][j - 1];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				} else if (j == 0) {
					if (grid[i][j] > grid[i - 1][j]) {
						dp[i][j] = grid[i][j] - grid[i - 1][j] + dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				} else {
					// [i-1][j] ->[i][j]
					// [i][j-1] ->[i][j-1]
					if (grid[i - 1][j] >= grid[i][j] && grid[i][j - 1] >= grid[i][j]) {
						dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
					} else if (grid[i - 1][j] >= grid[i][j] && grid[i][j - 1] < grid[i][j]) {
						dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1] + grid[i][j] - grid[i][j - 1]);
					} else if (grid[i - 1][j] < grid[i][j] && grid[i][j - 1] >= grid[i][j]) {
						dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j] - grid[i - 1][j], dp[i][j - 1]);
					} else {
						dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j] - grid[i - 1][j],
								dp[i][j - 1] + grid[i][j] - grid[i][j - 1]);
					}
				}
			}
		}
		return dp[n - 1][n - 1];

	}

	private static void dump(int[][] grid, int[][] dp, int i, int j) {
		if (i == 0 && j == 0) {
			dp[0][0] = 0;
		} else if (i == 0) {
			if (grid[i][j] > grid[i][j - 1]) {
				dp[i][j] = grid[i][j] - grid[i][j - 1] + dp[i][j - 1];
			} else {
				dp[i][j] = dp[i][j - 1];
			}
		} else if (j == 0) {
			if (grid[i][j] > grid[i - 1][j]) {
				dp[i][j] = grid[i][j] - grid[i - 1][j] + dp[i - 1][j];
			} else {
				dp[i][j] = dp[i - 1][j];
			}
		} else {
			// [i-1][j] ->[i][j]
			// [i][j-1] ->[i][j-1]
			if (grid[i - 1][j] >= grid[i][j] && grid[i][j - 1] >= grid[i][j]) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
			} else if (grid[i - 1][j] >= grid[i][j] && grid[i][j - 1] < grid[i][j]) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1] + grid[i][j] - grid[i][j - 1]);
			} else if (grid[i - 1][j] < grid[i][j] && grid[i][j - 1] >= grid[i][j]) {
				dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j] - grid[i - 1][j], dp[i][j - 1]);
			} else {
				dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j] - grid[i - 1][j],
						dp[i][j - 1] + grid[i][j] - grid[i][j - 1]);
			}
		}

	}

	public static void main(String[] args) {
//�����ת���Ѿ�д�ã����������������뼴��,main�������벻���޸� ��
//�ص���ʵ��dump����
		Scanner in = new Scanner(System.in);
		String s = in.nextLine().trim();
		String[] array = s.split(";");
		int[][] grid = new int[array.length][array[0].split(",").length];
		for (int i = 0; i < array.length; i++) {
			String[] l = array[i].split(",");
			for (int k = 0; k < l.length; k++) {
				grid[i][k] = Integer.parseInt(l[k]);
			}
		}
		int res = dump(grid);
		System.out.println(String.valueOf(res));
	}
}