
import java.util.Scanner;

public class Main{
	
	static int vertex;
	static int edge;
	static int[][] graph;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		vertex = scan.nextInt();
		edge = scan.nextInt();
		
		graph = new int[vertex+1][vertex+1];
		check = new boolean[vertex+1];
		
		for(int i = 1; i <= edge; i++) {
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			
			graph[v1][v2] = graph[v2][v1] = 1;
		}
		
		int result = 0;
		for(int i = 1; i <= vertex; i++) {
			if(!check[i]) {
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void dfs(int start) {
		check[start] = true;
		
		for(int i = 1; i <= vertex; i++) {
			if(graph[start][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
	}

}
