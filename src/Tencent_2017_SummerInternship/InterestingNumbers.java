package Tencent_2017_SummerInternship;

/*
	时间限制：1秒
	空间限制：32768K
	
	小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
	
	输入描述:
	 	输入包含多组测试数据。
	
	 对于每组测试数据：
		 N - 本组测试数据有n个数
		 a1,a2...an - 需要计算的数据
	
	 保证:
	 	1<=N<=100000,0<=ai<=INT_MAX.
	
	输出描述:
		对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
	
	输入例子1:
		6
		45 12 45 32 5 6	
	输出例子1:
		1 2
 */
import java.util.Scanner;
import java.util.HashMap;

public class InterestingNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.nextLine();
		String[] strarr = str.split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(strarr[i]);
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = Math.abs(arr[i] - arr[j]);
				if (map.containsKey(temp)) {
					int count = map.get(temp);
					map.put(temp, count + 1);
				} else {
					map.put(temp, 1);
				}
			}
		}
		int[][] result = new int[map.size()][2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int b = 0;
		for (Integer y : map.keySet()) {
			result[b][0] = y;
			result[b++][1] = map.get(y);
			if (y <= min) {
				min = y;
			} else if (y >= max) {
				max = y;
			}
		}
		int resultMin = 0;
		int resultMax = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i][0] == min) {
				resultMin = result[i][1];
			}
			if (result[i][0] == max) {
				resultMax = result[i][1];
			}
		}
		System.out.println(resultMin + " " + resultMax);

	}

}
