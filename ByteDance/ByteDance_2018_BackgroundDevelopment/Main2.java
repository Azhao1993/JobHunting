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
//		// n ������
//		int n = sc.nextInt();
//		// ����m��
//		int m = sc.nextInt();
//		// c����ɫ
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
//		// ������ɫ
//		for (int x = 0; x < c; x++) {
//			// ��������
//			for (int y = 0; y < list.size(); y++) {
//				//���������ŵ���ɫ
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
		int n = sc.nextInt(); // n������
		int m = sc.nextInt(); // �ִ��ϵ�����һ����ɫ����������ɫ����������������m���������������һ��
		int c = sc.nextInt(); // ��ɫһ����c��
		int count = 0;
		// key ��ɫ - value λ���б�
		Map<Integer, List<Integer>> map = new HashMap<>();
		// ����n������
		for (int i = 0; i < n; i++) {
			// ��i�������ϵ�num����ɫ
			int num = sc.nextInt();
			for (int j = 0; j < num; j++) {
				// ��i�����ϵ���ɫkey
				int key = sc.nextInt();
				// ��key - value �����map
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
		// ����c����ɫ
		for (int i = 1; i <= c; i++) {
			// ��־λ
			boolean flag = false;
			List<Integer> list = map.get(i);
			if (list.size() == 1) {
				continue;
			} else {
				// ���������б�
				for (int j = 0; j < list.size() - 1; j++) {
					if (list.get(j + 1) - list.get(j) < m) {
						count++;
						flag = true;
						break;
					}
				}
				// ���һ���͵�һ��
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
