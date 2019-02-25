package Tencent_2017_SummerInternship;
/*
	时间限制：1秒	
	空间限制：32768K
	
	小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
	你能帮帮小Q吗？
	
	输入描述:	
		输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.	
	输出描述:	
		对于每组数据，输出移位后的字符串。	
	
	输入例子1:
		AkleBiCeilD	
	输出例子1:
		kleieilABCD
 */

import java.util.Scanner;

//算法基础-字符移位
public class CharacterShift {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String temp = sc.nextLine();
			sloution(temp);
			// System.out.println(result);
		}
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
