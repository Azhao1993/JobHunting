package Tencent_2017_SummerInternship;

/*
	时间限制：1秒
	空间限制：32768K
	
	给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
	输出需要删除的字符个数。
	
	输入描述:
		输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
	输出描述:
		对于每组数据，输出一个整数，代表最少需要删除的字符个数。
	
	输入例子1:
		abcda
		google
	输出例子1:
		2
		2
 */
import java.util.Scanner;
//构造回文
public class ConstructingPalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			int result = sloution(temp);
			System.out.println(result);
		}
	}

	public static int sloution(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int l = 1; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = l + i - 1;
				if (i == j) {
					dp[i][j] = 1;
					continue;
				}

				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return n - dp[0][n - 1];
	}
}
