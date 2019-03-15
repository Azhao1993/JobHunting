package ByteDance_2018_BackgroundDevelopment;

import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt();
//		// 用户及喜好读
//		int[] fav = new int[n];
//		for (int i = 0; i < n; i++) {
//			fav[i] = sc.nextInt();
//		}
//		// q组数据
//		int q = sc.nextInt();
//		for (int i = 0; i < q; i++) {
//			int l = sc.nextInt();// 左端点
//			int r = sc.nextInt();// 右端点
//			int k = sc.nextInt();// 喜好度
//			int count = sloution(l, r, k, fav);
//			System.out.println(count);
//		}
//
//	}
//
//	private static int sloution(int l, int r, int k, int[] fav) {
//		int count = 0;
//		for (int i = l; i <= r; i++) {
//			if (fav[i - 1] == k) {
//				count++;
//			}
//		}
//		return count;
//
//	}
//
//}

//
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();// n个用户
		int[] fav = new int[n];
		for (int i = 0; i < n; i++) {
			fav[i] = scan.nextInt();
		}
		// key 喜好度-value 用户
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int key = fav[i];
			int value = i + 1;
			if (!map.containsKey(key)) {
				List<Integer> list = new LinkedList<>();
				list.add(value);
				map.put(key, list);
			} else {
				List<Integer> list = map.get(key);
				list.add(value);
			}
		}
		// m 组数
		int m = scan.nextInt();
		// 将结果存入队列
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			// 左端点
			int lo = scan.nextInt();
			// 右端点
			int hi = scan.nextInt();
			// 查找的喜好度
			int des = scan.nextInt();
			// 取出喜好对对应的用户列表
			List<Integer> list = map.get(des);
			int count = 0;// 计数器
			if (list != null) {
				// 遍历此用户列表
				for (Integer integer : list) {
					// 符合条件的用户
					if (integer >= lo && integer <= hi) {
						count++;
					}
				}
			}

			queue.add(count);

		}
		for (Integer integer : queue) {
			System.out.println(integer);
		}

	}
}
