package ByteDance_2018_BackgroundDevelopment;
//

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main2 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		// n 个珠子
//		int n = sc.nextInt();
//		// 连续m个
//		int m = sc.nextInt();
//		// c个颜色
//		int c = sc.nextInt();
//		List<List<Integer>> list = new ArrayList<List<Integer>>();
//		for (int i = 0; i < n; i++) {
//			int cc = sc.nextInt();
//			List<Integer> clist = new ArrayList<Integer>();
//			for (int j = 0; j < cc; j++) {
//				clist.add(sc.nextInt());
//			}
//			list.add(clist);
//		}
//		solution(m, c, list);
//
//	}
//
//	private static void solution(int m, int c, List<List<Integer>> list) {
//		int result = 0;
//		// 遍历颜色
//		for (int x = 0; x < c; x++) {
//			// 遍历珠子
//			for (int y = 0; y < list.size(); y++) {
//				//遍历珠子张的颜色
//				
//			}
//		}
//
//	}
//
//}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n个串珠
		int m = sc.nextInt(); // 手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次
		int c = sc.nextInt(); // 颜色一共有c种
		int count = 0;
		// key 颜色 - value 位置列表
		Map<Integer, List<Integer>> map = new HashMap<>();
		// 遍历n个珠子
		for (int i = 0; i < n; i++) {
			// 第i颗珠子上的num中颜色
			int num = sc.nextInt();
			for (int j = 0; j < num; j++) {
				// 第i珠子上的颜色key
				int key = sc.nextInt();
				// 将key - value 添加至map
				if (!map.containsKey(key)) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					map.put(key, list);
				} else {
					List<Integer> list = map.get(key);
					list.add(i);
				}
			}
		}
		// 遍历c中颜色
		for (int i = 1; i <= c; i++) {
			// 标志位
			boolean flag = false;
			List<Integer> list = map.get(i);
			if (list.size() == 1) {
				continue;
			} else {
				// 遍历珠子列表
				for (int j = 0; j < list.size() - 1; j++) {
					if (list.get(j + 1) - list.get(j) < m) {
						count++;
						flag = true;
						break;
					}
				}
				// 最后一个和第一个
				if (!flag) {
					if ((n - list.get(list.size() - 1) + list.get(0)) < m) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

}
