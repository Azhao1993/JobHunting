package NTES_2019_GameTestDevelopmentEngineer_1;

import java.util.Scanner;

/*
������Ϸ�����飩2019��-��Ϸ���Կ�������ʦ��������
һ����ֵ���
	ʱ�����ƣ�1��
	�ռ����ƣ�32768K
	
	��������Ҫ��һ̨��ֵĴ��ֻ���дһ�����š�
	�ŵ�ÿ��ֻ�����ɿ��Ϊ100���ַ���Ҳ����˵���д��ĳ���ַ��ᵼ���п���100����ô��Ҫ����һ����д��
	�ŵ�������a-z��26��Сд��ĸ���ɣ���ÿ����ĸ�Ŀ�Ⱦ�������Լ����
	�����ַ����Լ��Ϊ[1,2,3,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5]��
	��ô�ʹ���'a'��'d'�ĸ���ĸ�Ŀ�ȷֱ���1,2,3,4����'e'��'z'�Ŀ�Ⱦ�Ϊ5
	��ô�����������򽫸�������S��д��һ���ź�����Ź��м��У����һ�п���Ƕ��٣�
	
	��������:
		����Ϊ���У�
		��һ���Ǵ洢��ÿ���ַ���ȵ��ַ���������26�����֣���1���ո�ָ���ÿ�����־�С�ڵ���10
		�ڶ����Ǵ洢�˴������ַ����ַ���S���ַ���S�ĳ�����1��1000֮��	
	�������:
		���Ϊ�ŵ������Լ����һ�����������ַ��������м���1���ո�ָ�
	
	��������1:
		5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
		helloworld	
	�������1:
		1 50	
	����˵��1:
		"5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5"�涨ÿ���ַ����Ϊ5
		"helloworld"��������ַ���S
		����S������10���ַ���Ҳ����ռ��50���ַ���ȣ���˿���д��ͬһ��	
	
	��������2:
		5 5 5 5 5 5 10 10 10 10 10 10 10 10 10 10 10 10 5 5 5 5 5 5 5 5
		hahahahahahahaha	
	�������2:
		2 20	
	����˵��2:
		"5 5 5 5 5 5 10 10 10 10 10 10 10 10 10 10 10 10 5 5 5 5 5 5 5 5"�涨��ÿ���ַ����
		"hahahahahahahaha"��������ַ���S
		����h���Ϊ10��a���Ϊ5�����'hahahahahahah'ռ��100�ַ���ȿ���д�ڵ�һ�У���aha��д�ڵڶ���Ҳ�����һ�С�����ַ����Ϊ20
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {

			int[] width = new int[26];
			for (int i = 0; i < 26; i++) {
				width[i] = sc.nextInt();
			}
			String str = sc.next();
			int[] result = sloution(width, str);
			System.out.println(result[0] + " " + result[1]);
		}
	}

	public static int[] sloution(int[] width, String str) {
		int[] result = { 1, 0 };
		if (str == null || str.length() == 0) {
			return result;
		}
		for (int i = 0; i < str.length(); i++) {
			result[1] = result[1] + width[str.charAt(i) - 'a'];
			if (result[1] > 100) {
				result[1] = width[str.charAt(i) - 'a'];
				result[0]++;
			} else if (result[1] == 100) {
				result[0]++;
				result[1] = 0;
			}
		}
		return result;
	}
}
