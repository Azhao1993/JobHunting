package Ailibaba_2020_test;

/*
��Ŀ������

С�㸽���мҺ���꣬�õ��ṩ���ͷ������ͷ�Χ��ϵͳ���ݸ���ָ����߳���һ������Σ�����С�����ڵ�λ��Ϊ��x,y��������С���Ƿ��ڸú��������ͷ�Χ�ڣ�����������ͷ�Χ��������Ҫ����Ҫ�߶��پ�����ܵ���������ͷ�Χ�ڡ�����������ڶ�άƽ���ϣ������ǵ������ʵ����ء�

 

���룺

x,y(����С�����ڵ�λ�ã�x��ʾ�����꣬y��ʾ������)

x1,y1,x2,y2,x3,y3....xn,yn(����ú��������ͷ�Χ����Σ�����x��ʾ�����꣬y��ʾ�����꣬xi��yi��������һ���㣬����㰴˳�������γɱߣ��������һ����(xn,yn)���һ����(x1,y1)������

�����

����С���Ƿ��ں��������ͷ�Χ�ڣ�����������ͷ�Χ��������Ҫ�����߶��پ�����ܵ���������ͷ�Χ�ڣ�������Ϊ�������������룩

 

����˵����

���룺

1,1
0,0,0,2,2,2,2,0

�����

yes,0

 

���룺

2,2
0,0,0,2,2,2,2,0

�����

yes,0

 

���룺

3,0
0,0,0,2,2,2,2,0

�����

no,1

 

���룺

3,4
0,0,0,2,2,2,2,0

�����

no,2
 */
import java.util.*;
import java.util.List;

public class Main {
	/** ������������������ʵ����ĿҪ��Ĺ��� **/
	/**
	 * ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨��
	 **/
	public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		// (x,y)ΪС�����ڵ�λ��
		double x = Double.parseDouble(line.split(",")[0]);
		double y = Double.parseDouble(line.split(",")[1]);

		line = in.nextLine();
		// xList��¼�˶����n�����x����,yList��¼�˶����n�����y����
		List<Double> xList = new ArrayList<>();
		List<Double> yList = new ArrayList<>();
		String[] array = line.split(",");
		for (int i = 0; i < array.length; i++) {
			xList.add(Double.parseDouble(array[i]));
			yList.add(Double.parseDouble(array[i + 1]));
			i++;
		}
		in.close();
		System.out.println(measureDistance(xList, yList, x, y));
	}
}
