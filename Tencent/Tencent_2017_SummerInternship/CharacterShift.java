package Tencent_2017_SummerInternship;
/*
	ʱ�����ƣ�1��	
	�ռ����ƣ�32768K
	
	СQ���������һ�����⣺��һ���ַ����Ĵ�д��ĸ�ŵ��ַ����ĺ��棬�����ַ������λ�ò��䣬�Ҳ����������Ŀռ䡣
	���ܰ��СQ��
	
	��������:	
		���������ж��飬ÿ�����һ���ַ���s���ұ�֤:1<=s.length<=1000.	
	�������:	
		����ÿ�����ݣ������λ����ַ�����	
	
	��������1:
		AkleBiCeilD	
	�������1:
		kleieilABCD
 */

import java.util.Scanner;

//�㷨����-�ַ���λ
public class CharacterShift {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			getResult(temp);
			// System.out.println(result);
		}
	}
	
	public static void getResult(String str){          
        System.out.println(str.replaceAll("[A-Z]","")+str.replaceAll("[a-z]",""));
    }

	public static void sloution(String s) {
		
		int length = s.length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				System.out.print(s.charAt(i));
			} else {
				count++;
				s += s.charAt(i);
			}
		}
		System.out.println(s.substring(length, length + count));
	}
}
