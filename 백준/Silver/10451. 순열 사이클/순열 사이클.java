
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int vertex;
	static List<List<Integer>> graph;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int cases = scan.nextInt();
		
		while(cases-- > 0) {
			vertex = scan.nextInt();
			graph = new ArrayList<>();
			check = new boolean[vertex+1];
			for(int i = 0; i <= vertex; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i = 1; i<= vertex; i++) {
				int v = scan.nextInt();
				graph.get(i).add(v);
				graph.get(v).add(i);
			}
			
			int count = 0;
			for(int i = 1; i <= vertex; i++) {
				if(!check[i]) {
					dfs(i);
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void dfs(int start) {
		check[start] = true;
		
		for(int i: graph.get(start)) {
			if(!check[i]) {
				dfs(i);
			}
		}
	}
}
