package HUAWEI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] flag = new boolean[5];
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < 5; i++) {
			int[] node = new int[2];
			node[0] = sc.nextInt();
			node[1] = sc.nextInt();
			list.add(node);
		}
		int res = Integer.MAX_VALUE;
		int cur = -1;
		res = dfs(list, res, flag, 0, 0, cur);
		System.out.println(res);

	}

	private static int dfs(List<int[]> list, int res, boolean[] flag, int st, int sum, int cur) {
		if (st == 5) {
			// 回到原点
			int dis = (int) Math.sqrt(
					(list.get(cur)[0] - 0) * (list.get(cur)[0] - 0) + (list.get(cur)[1] - 0) * (list.get(cur)[1] - 0));
			sum += dis;
			res = Math.min(res, sum);
			return res;
		}
		// pair<int,int> curP;
		int[] curP = new int[2];
		if (cur == -1) {
			curP[0] = 0;
			curP[1] = 0;
			// curP = pair<int,int>({0,0});
		} else {
			curP = list.get(cur);
		}
		for (int i = 0; i < 5; ++i) {
			if (flag[i]) {
				continue;
			}
			int dis = (int) Math.sqrt((list.get(i)[0] - curP[0]) * (list.get(i)[0] - curP[0])
					+ (list.get(i)[1] - curP[1]) * (list.get(i)[1] - curP[1]));
			sum += dis;
			flag[i] = true;
			res = dfs(list, res, flag, st + 1, sum, i);
			// dfs(arr,res,flag,st+1,sum,i);
			flag[i] = false;
			sum -= dis;
		}
		return res;
	}

}
