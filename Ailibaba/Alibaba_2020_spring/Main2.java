package Alibaba;

/*
������һ��������Ϸ��һ����˵����һ��n��n�еķ���,ÿ��λ�ö���һ�����������Ҹ߶Ȳ�ͬ�ķ��飬�߶�����֪�ģ���������ȥ֮������Լ�����������ÿ������������ٶ���ÿ1��λʱ��������1��λ�߶ȣ�Ҫ������������ٶȴ�(0,0)����(n-1,n-1)�ķ��飬��һ��������Ծ������һ�����飬ֻ���ڸ߶���ͬ���ߴӸߵ����͵��ƶ������һ������ĸ߶ȱ���Χ�ĵͣ���ô��Ҫ�ȴ�����߶�����Χ��������һ����ͬʱ�����ƶ��������ȴ������ʱ��
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {

	/** ������������������ʵ����ĿҪ��Ĺ��� **/
	/** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^ **/
	static int dump(int[][] grid) {

	}

	public static void main(String[] args) {
//�����ת���Ѿ�д�ã����������������뼴��,main�������벻���޸� ��
//�ص���ʵ��dump����
		Scanner in = new Scanner(System.in);
		String s = in.nextLine().trim();
		String[] array = s.split(";");
		int[][] grid = new int[array.length][array[0].split(",").length];
		for (int i = 0; i < array.length; i++) {
			String[] l = array[i].split(",");
			for (int k = 0; k < l.length; k++) {
				grid[i][k] = Integer.parseInt(l[k]);
			}
		}
		int res = dump(grid);
		System.out.println(String.valueOf(res));
	}
}