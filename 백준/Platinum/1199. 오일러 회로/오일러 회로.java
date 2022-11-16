
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] graph;
	static int vertex;
	
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		vertex = Integer.parseInt(br.readLine());

		graph = new int[vertex][vertex];

		for (int i = 0; i < vertex; i++) {
			st = new StringTokenizer(br.readLine());
			int count = 0;
			
			for (int j = 0; j < vertex; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				count += graph[i][j];
			}
			if(count % 2 == 1) {
				System.out.println(-1);
				return;
			}
		}
		
		sb = new StringBuilder();
		dfs(0);
		System.out.println(sb.toString());
	}

	public static void dfs(int start) {
		for (int i = 0; i < graph.length; i++) {
			while(graph[start][i] > 0) {
				graph[start][i]--;
				graph[i][start]--;
				dfs(i);
			}
		}
		
		sb.append((start + 1) + " ");
	}

}
