
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static List<List<Node>> graph;
	static int V;
	static int E;
	static int[] distance;
	static int start;
	static int INF = Integer.MAX_VALUE;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		
		graph = new ArrayList<>();
		distance = new int[V + 1];
		check = new boolean[V + 1];
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		for (int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();
			graph.get(v1).add(new Node(v2, w));
		}
		
		dijkstra();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
	}

	private static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (check[node.v]) {
				continue;
			}
			
			check[node.v] = true;
			
			for(Node n : graph.get(node.v)) {
				int totalW = n.w + node.w;
				if(distance[n.v] > totalW) {
					distance[n.v] = totalW;
					queue.add(new Node(n.v, totalW));
				}
			}
			
		}

	}

	public static class Node implements Comparable<Node> {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}
}