package JingDong_2020_Spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		HashMap<Integer, Node> keytonode = new HashMap<>();
		// HashMap<Node,Integer> nodetokey = new HashMap<>();
		for (int i = 1; i < n; i++) {
			String[] temp = sc.nextLine().split(" ");
			int value1 = Integer.parseInt(temp[0]);
			int value2 = Integer.parseInt(temp[1]);
			if (!keytonode.containsKey(value1)) {
				Node node = new Node(value1);
				keytonode.put(value1, node);				
			}

			if (!keytonode.containsKey(value2)) {
				Node node = new Node(value2);
				keytonode.put(value2, node);				
			}
			keytonode.get(value2).next.add(keytonode.get(value1));
		}

		Node head = keytonode.get(1);

		int res = getMax(keytonode, head);
		System.out.println(res);

	}

	private static int getMax(HashMap<Integer, Node> keytonode, Node head) {
		if (head == null) {
			return 0;
		}
		int res = 0;
		for (Node nexts:head.next) {			
			res = Math.max(res, getMax(keytonode, nexts));
		}
		return res+1;
	}

}

class Node {
	int val;
	ArrayList<Node> next;

	Node(int val) {
		this.val = val;
		next = new ArrayList<Node>();
	}
}
