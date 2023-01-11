
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int vertex;
	static List<List<TreeNode>> graph;
	static int[] distance;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		vertex = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		distance = new int[vertex+1];

		for(int i = 0; i <= vertex; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= vertex-1; i++) {
			String[] temp = br.readLine().split(" ");
			
			int v1 = Integer.parseInt(temp[0]);
			int v2 = Integer.parseInt(temp[1]);
			int w = Integer.parseInt(temp[2]);
			
			graph.get(v1).add(new TreeNode(v2, w));
			graph.get(v2).add(new TreeNode(v1, w));
		}
		
		Arrays.fill(distance, -1);
		distance[1] = 0;
		
		dfs(1, 0);

		int max = 0;
		int maxi = 0;
		
		for(int i = 1; i <= vertex; i++) {
			if(max < distance[i]) {
				max = distance[i];
				maxi = i;
			}
		}
		
		Arrays.fill(distance, -1);
		
		distance[maxi] = 0;
		
		dfs(maxi, 0);
		
		max = 0;
		
		for(int i = 1; i <= vertex; i++) {
		
			if(max < distance[i]) {
				max = distance[i];
			}
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int start, int w) {
		for(TreeNode tn : graph.get(start)) {
			if(distance[tn.v] == -1) {
				distance[tn.v] = w + tn.w;
				dfs(tn.v, distance[tn.v]);
			}
		}
	}
}

class TreeNode{
	int v;
	int w;
	
	public TreeNode(int v, int w) {
		this.v = v;
		this.w = w;
	}
}
