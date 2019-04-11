package Ailibaba_2020_test;

import java.awt.geom.Point2D;
/*
	题目描述：	
		小广附近有家盒马店，该店提供配送服务，
		配送范围是系统根据各项指标决策出的一个多边形，
		假设小广现在的位置为（x,y），
		请问小广是否在该盒马店的配送范围内，
		如果不在配送范围内请问他要最少要走多少距离才能到盒马店配送范围内。
		假设坐标点在二维平面上，不考虑地球曲率等因素。	 
	
	输入：	
		x,y(代表小广所在的位置，x表示横坐标，y表示纵坐标)	
		x1,y1,x2,y2,x3,y3....xn,yn
		(代表该盒马店的配送范围多边形，
		其中x表示横坐标，
		y表示纵坐标，
		xi和yi代表多边形一个点，
		点与点按顺序相连形成边，
		并且最后一个点(xn,yn)与第一个点(x1,y1)相连）
	
	输出：	
		请问小广是否在盒马店的配送范围内，
		如果不在配送范围内请问他要最少走多少距离才能到盒马店配送范围内，
		输出结果为整数（四舍五入）	 
	
	举例说明：	
		输入：		
			1,1
			0,0,0,2,2,2,2,0		
		输出：		
			yes,0		
		
		输入：	
			2,2
			0,0,0,2,2,2,2,0		
		输出：		
			yes,0		 
		
		输入：		
			3,0
			0,0,0,2,2,2,2,0		
		输出：		
			no,1		 
		
		输入：		
			3,4
			0,0,0,2,2,2,2,0		
		输出：		
			no,2
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	/** 请完成下面这个函数，实现题目要求的功能 **/
	/**
	 * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
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
		// (x,y)为小广所在的位置
		double x = Double.parseDouble(line.split(",")[0]);
		double y = Double.parseDouble(line.split(",")[1]);

		line = in.nextLine();
		// xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
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
		// (x,y)为小广所在的位置
		double x = Double.parseDouble(line.split(",")[0]);
		double y = Double.parseDouble(line.split(",")[1]);
		Point2D.Double point = new Point2D.Double(x, y);
		line = in.nextLine();
		// xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
		List<Point2D.Double> pts = new ArrayList<>();
		String[] array = line.split(",");
		for (int i = 0; i < array.length; i++) {
			pts.add(new Point2D.Double(Double.parseDouble(array[i]), Double.parseDouble(array[i + 1])));
			i++;
		}
		in.close();
		System.out.println(measureDistance(point, pts));
	}

	// 判断一个点是否在一个区域内
	public static boolean IsPtInPoly(Point2D.Double point, List<Point2D.Double> pts) {

		int N = pts.size();
		boolean boundOrVertex = true; // 如果点位于多边形的顶点或边上，也算做点在多边形内，直接返回true
		int intersectCount = 0;// cross points count of x
		double precision = 2e-10; // 浮点类型计算时候与0比较时候的容差
		Point2D.Double p1, p2;// neighbour bound vertices
		Point2D.Double p = point; // 当前点

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

		if (intersectCount % 2 == 0) {// 偶数在多边形外
			return false;
		} else { // 奇数在多边形内
			return true;
		}

	}

}
