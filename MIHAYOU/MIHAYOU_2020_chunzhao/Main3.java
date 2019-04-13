package MIHAYOU_2020_chunzhao;

import java.util.HashSet;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//HashSet<Node> set = new HashSet<Node>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int len = sc.nextInt();
			for (int dx = 0; dx < len; dx++) {
				for (int dy = 0; dy < len; dy++) {
					//set.add(new Node(x + dx, y + dy));
					set.add((x+dx)*65535+y+dy);
				}
			}
		}
		System.out.println(set.size());
	}
}

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x + y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (x == other.x && y == other.y) {
			return true;
		} else {
			return false;
		}
	}

}
