package Alibaba;

/*
现在有一个真人游戏跳一跳，说是在一个n行n列的方阵,
每个位置都有一个可以升降且高度不同的方块，高度是已知的，
当人跳上去之后可以自己控制升降，每个方块的升降速度是每1单位时间能升高1单位高度，
要求玩家以最快的速度从(0,0)到达(n-1,n-1)的方块，
从一个方块跳跃到另外一个方块，只能在高度相同或者从高的往低的移动，
如果一个方块的高度比周围的低，
那么需要等待方块高度与周围方块任意一个相同时才能移动，请计算等待的最短时间
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {

	/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
	static int dump(int[][] grid) {
		int n = grid.length;
		// dp[i][j]表示到i,j最少需要的时间
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
//这里的转换已经写好，按照输入描述输入即可,main方法代码不用修改 ，
//重点在实现dump方法
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