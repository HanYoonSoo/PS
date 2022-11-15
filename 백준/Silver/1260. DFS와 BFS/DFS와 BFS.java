
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int vertex;
	static int edge;
	static int[][] graph;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		vertex = scan.nextInt();
		edge = scan.nextInt();
		int start = scan.nextInt();
		
		graph = new int[vertex+1][vertex+1];
		check = new boolean[vertex+1];
		for(int i = 1; i <= edge; i++) {
			int v = scan.nextInt();
			int e = scan.nextInt();
			
			graph[v][e] = graph[e][v] = 1;
		}
		
		dfs(start);
		check = new boolean[vertex+1];
		System.out.println();
		bfs(start);
	}
	
	public static void dfs(int start) {
		check[start] = true;
		System.out.print(start + " ");
		
		
		for(int i = 1; i <= vertex; i++) {
			if(graph[start][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> q  = new LinkedList<>();
		check[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v + " ");
			for(int i = 1; i <= vertex; i++) {
				if(graph[v][i] == 1 && !check[i]) {
					check[i] = true;
					q.add(i);
				}
			}
		}
	}
}
