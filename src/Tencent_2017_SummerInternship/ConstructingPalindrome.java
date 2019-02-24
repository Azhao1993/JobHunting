package Tencent_2017_SummerInternship;

/*
	ʱ�����ƣ�1��
	�ռ����ƣ�32768K
	
	����һ���ַ���s������Դ���ɾ��һЩ�ַ���ʹ��ʣ�µĴ���һ�����Ĵ������ɾ������ʹ�û��Ĵ���أ�
	�����Ҫɾ�����ַ�������
	
	��������:
		���������ж��飬ÿ�����һ���ַ���s���ұ�֤:1<=s.length<=1000.
	�������:
		����ÿ�����ݣ����һ������������������Ҫɾ�����ַ�������
	
	��������1:
		abcda
		google
	�������1:
		2
		2
 */
import java.util.Scanner;
//�������
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
