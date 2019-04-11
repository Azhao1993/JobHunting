package Ailibaba_2020_test;

import java.awt.geom.Point2D;
/*
	��Ŀ������	
		С�㸽���мҺ���꣬�õ��ṩ���ͷ���
		���ͷ�Χ��ϵͳ���ݸ���ָ����߳���һ������Σ�
		����С�����ڵ�λ��Ϊ��x,y����
		����С���Ƿ��ڸú��������ͷ�Χ�ڣ�
		����������ͷ�Χ��������Ҫ����Ҫ�߶��پ�����ܵ���������ͷ�Χ�ڡ�
		����������ڶ�άƽ���ϣ������ǵ������ʵ����ء�	 
	
	���룺	
		x,y(����С�����ڵ�λ�ã�x��ʾ�����꣬y��ʾ������)	
		x1,y1,x2,y2,x3,y3....xn,yn
		(����ú��������ͷ�Χ����Σ�
		����x��ʾ�����꣬
		y��ʾ�����꣬
		xi��yi��������һ���㣬
		����㰴˳�������γɱߣ�
		�������һ����(xn,yn)���һ����(x1,y1)������
	
	�����	
		����С���Ƿ��ں��������ͷ�Χ�ڣ�
		����������ͷ�Χ��������Ҫ�����߶��پ�����ܵ���������ͷ�Χ�ڣ�
		������Ϊ�������������룩	 
	
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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	/** ������������������ʵ����ĿҪ��Ĺ��� **/
	/**
	 * ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨��
	 **/
	public static String measureDistance(Point2D.Double point, List<Point2D.Double> pts) {		
		if(IsPtInPoly(point, pts)) {
			return "yes,0";
		}else {
			
		}
	}

	public static void main2(String[] args) {
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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		// (x,y)ΪС�����ڵ�λ��
		double x = Double.parseDouble(line.split(",")[0]);
		double y = Double.parseDouble(line.split(",")[1]);
		Point2D.Double point = new Point2D.Double(x, y);
		line = in.nextLine();
		// xList��¼�˶����n�����x����,yList��¼�˶����n�����y����
		List<Point2D.Double> pts = new ArrayList<>();
		String[] array = line.split(",");
		for (int i = 0; i < array.length; i++) {
			pts.add(new Point2D.Double(Double.parseDouble(array[i]), Double.parseDouble(array[i + 1])));
			i++;
		}
		in.close();
		System.out.println(measureDistance(point, pts));
	}

	// �ж�һ�����Ƿ���һ��������
	public static boolean IsPtInPoly(Point2D.Double point, List<Point2D.Double> pts) {

		int N = pts.size();
		boolean boundOrVertex = true; // �����λ�ڶ���εĶ������ϣ�Ҳ�������ڶ�����ڣ�ֱ�ӷ���true
		int intersectCount = 0;// cross points count of x
		double precision = 2e-10; // �������ͼ���ʱ����0�Ƚ�ʱ����ݲ�
		Point2D.Double p1, p2;// neighbour bound vertices
		Point2D.Double p = point; // ��ǰ��

		p1 = pts.get(0);// left vertex
		for (int i = 1; i <= N; ++i) {// check all rays
			if (p.equals(p1)) {
				return boundOrVertex;// p is an vertex
			}

			p2 = pts.get(i % N);// right vertex
			if (p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)) {// ray is outside of our interests
				p1 = p2;
				continue;// next ray left point
			}

			if (p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)) {// ray is crossing over by the algorithm
																			// (common part of)
				if (p.y <= Math.max(p1.y, p2.y)) {// x is before of ray
					if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)) {// overlies on a horizontal ray
						return boundOrVertex;
					}

					if (p1.y == p2.y) {// ray is vertical
						if (p1.y == p.y) {// overlies on a vertical ray
							return boundOrVertex;
						} else {// before ray
							++intersectCount;
						}
					} else {// cross point on the left side
						double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;// cross point of y
						if (Math.abs(p.y - xinters) < precision) {// overlies on a ray
							return boundOrVertex;
						}

						if (p.y < xinters) {// before ray
							++intersectCount;
						}
					}
				}
			} else {// special case when ray is crossing through the vertex
				if (p.x == p2.x && p.y <= p2.y) {// p crossing over p2
					Point2D.Double p3 = pts.get((i + 1) % N); // next vertex
					if (p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)) {// p.x lies between p1.x & p3.x
						++intersectCount;
					} else {
						intersectCount += 2;
					}
				}
			}
			p1 = p2;// next ray left point
		}

		if (intersectCount % 2 == 0) {// ż���ڶ������
			return false;
		} else { // �����ڶ������
			return true;
		}

	}

}
