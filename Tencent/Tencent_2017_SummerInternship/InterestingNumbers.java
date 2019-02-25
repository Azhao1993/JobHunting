package Tencent_2017_SummerInternship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
//有趣的数字
public class InterestingNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			// 最小值
			int min = Integer.MAX_VALUE;
			// 最大值
			int max = Integer.MIN_VALUE;
			// 最小值的个数
			int minCount = 0;
			// 最小值的个数
			int maxCount = 0;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
				if (min > arr[i]) {
					min = arr[i];
					minCount = 1;

				} else if (arr[i] == min) {
					minCount++;
				}

				if (max < arr[i]) {
					max = arr[i];
					maxCount = 1;
				} else if (arr[i] == max) {
					maxCount++;
				}

			}
			// 如果数组中的值全相同，直接两两组合
			if (min == max) {
				int tmp = (n * (n - 1)) / 2;
				System.out.println(tmp + " " + tmp);
				continue;
			}
			Arrays.sort(arr);// 时间复杂度太高

			int res_min_dif = 0;
			// 最小差为0
			if (map.keySet().size() != n) {
				for (Integer temp : map.keySet()) {
					if (map.get(temp) > 1) {
						res_min_dif += (map.get(temp) - 1) * map.get(temp) / 2;
					}
				}
			} else {
				// 最小差不为0
				int mindif = Math.abs(arr[1] - arr[0]);
				// int count = 0;
				for (int i = 2; i < n; i++) {
					if (mindif == Math.abs(arr[i] - arr[i - 1])) {
						res_min_dif++;
					} else if (mindif > Math.abs(arr[i] - arr[i - 1])) {
						mindif = Math.abs(arr[i] - arr[i - 1]);
						res_min_dif = 1;
					}
				}
			}

			System.out.println(res_min_dif + " " + (minCount * maxCount));
		}

	}

}