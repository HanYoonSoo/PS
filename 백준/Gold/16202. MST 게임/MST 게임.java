
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int vertex;
	static int edge;
	static int k;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static PriorityQueue<Edge> mst;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		vertex = scan.nextInt();
		edge = scan.nextInt();
		k = scan.nextInt();
		
		for(int i = 1; i <= edge; i++) {
			int e1 = scan.nextInt();
			int e2 = scan.nextInt();
			pq.offer(new Edge(e1, e2, i));
		}
		
		for(int i = 1; i <= k; i++) {
			mst = new PriorityQueue<>();
			int result[] = kruskal1(vertex);
			
			if(result[1] == (vertex - 1)) {
				System.out.print(result[0] + " ");
			}
			else {
				for(int j = 0; j <= k - i; j++) {
					System.out.print("0 ");
					break;
				}
			}
			
			mst.poll();
			pq = mst;
		}
	}
	
	public static int[] kruskal1(int v) {
		int[] parent = new int[v+1];
		for(int i = 1; i <= v; i++) {
			parent[i] = i;
		}
		
		int total = 0;
		int size = 0;
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int p1 = find(e.e1, parent);
			int p2 = find(e.e2, parent);
			
			if(p1 != p2) {
				parent[p1] = p2;
				total += e.cost;
				size += 1;
			}
			
			mst.offer(e);
		}
		
		return new int[] {total, size};
	}
	
	public static int find(int v, int[] parent) {
		if(parent[v] == v)
			return v;
		else
			return parent[v] = find(parent[v], parent);
	}
	
	public static class Edge implements Comparable<Edge>{
		int e1;
		int e2;
		int cost;
		
		public Edge(int e1, int e2, int cost) {
			this.e1 = e1;
			this.e2 = e2;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
		
	}
}
