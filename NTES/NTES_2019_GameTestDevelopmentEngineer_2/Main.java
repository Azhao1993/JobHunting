package NTES_2019_GameTestDevelopmentEngineer_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
������Ϸ�����飩2019��-��Ϸ���Կ�������ʦ��������
�ǹ�����
	ʱ�����ƣ�1��
	�ռ����ƣ�32768K
	
	С�����׶�԰��һ����ʦ��ĳ���׶�԰԰����С������ÿ�˷�һ���ǹ���
	С�������õ�������һЩͬѧ�õ����ǹ���ɫ���Լ���ͬ����һЩͬѧ�ǹ���ɫ���Լ���ͬ��
	�ٶ�ÿ��С����ֻ֪���ж���ͬѧ���Լ��õ�����ͬ��ɫ���ǹ���
	�Ͽκ���һ����С�����˷ܵİ���һ�������С����ʦ������С����ʦ��һ�£������ж���ͬѧ�õ����ǹ���
	����������С���Ѹ���С����ʦ��һ������£�
	���е�һ��С���ѷ�����1�˺��Լ��ǹ���ɫһ�����ڶ���С����Ҳ������1�˺��Լ��ǹ���ɫһ����������С���ѷ�����3�˺��Լ��ǹ���ɫһ����
	��һ����С���ѿɻ�����Ϊ�Է����Լ���ɫ��ͬ�������ɫ��
	������С���Ѳ�������Ϊ��ɫ�������һ����С���ѻᷢ����2�˺��Լ��ǹ���ɫ��ͬ�����������õ���Ϊ��ɫ�ǹ�����ô���ٻ�������3λͬѧ�õ���ɫ���ǹ�������������6λС�����õ����ǹ���
	�����������С����ʦ�����������⡣
	
	��������:
		�ٶ�����С���ѵĻش��ÿո������� 1 1 3	
	�������:
		ֱ�Ӵ�ӡ�����ж���λС�����õ��ǹ�
		�� 6
	
	��������1:
		1 1 3	
	�������1:
		6
	
	��������2:
		0 0 0	
	�������2:
		3	
	����˵��2:
		��λС���Ѷ�û�������˺��Լ�����ɫ��ͬ���������ٵ����������λС�����ǹ�����ɫ����ͬ
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String[] strarr = str.split(" ");
		int result = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < strarr.length; i++) {
			int key = Integer.parseInt(strarr[i]);
			if (key == 0) {
				result++;
			} else if (!map.containsKey(key)) {
				map.put(key, 1);
			} else if (map.get(key) <= key) {
				map.put(key, map.get(key) + 1);
			} else {
				result += map.get(key);
				map.put(key, 1);
			}

		}
		for (Integer key : map.keySet()) {
			if (map.get(key) != 0) {
				result += key + 1;
			}
		}
		System.out.println(result);

	}

}
