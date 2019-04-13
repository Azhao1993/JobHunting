package ByteDance_2018_BackgroundDevelopment;

import java.util.Scanner;

import java.util.*;

//zi
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();// n���û�
		int[] fav = new int[n];
		for (int i = 0; i < n; i++) {
			fav[i] = scan.nextInt();
		}
		// key ϲ�ö�-value �û�
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
		// m ����
		int m = scan.nextInt();
		// ������������
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			// ��˵�
			int lo = scan.nextInt();
			// �Ҷ˵�
			int hi = scan.nextInt();
			// ���ҵ�ϲ�ö�
			int des = scan.nextInt();
			// ȡ��ϲ�öԶ�Ӧ���û��б�
			List<Integer> list = map.get(des);
			int count = 0;// ������
			if (list != null) {
				// �������û��б�
				for (Integer integer : list) {
					// �����������û�
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
