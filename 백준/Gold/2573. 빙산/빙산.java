
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		grid = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		int count = 0;
		int result = 0;
		
		while((count = iceCount()) < 2) {
			if(count == 0) {
				result = 0;
				break;
			}
			
			bfs();
			
			result++;
		}
		
		System.out.println(result);
	}
	
	public static int iceCount() {
		int count = 0;
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] != 0 && !visited[i][j]) {
					dfs(i, j, visited);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if(!visited[nx][ny] && grid[nx][ny] != 0) {
					dfs(nx, ny, visited);
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<Ice> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] != 0) {
					q.offer(new Ice(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Ice ice = q.poll();
			
			int seaCount = 0;
			
			for(int i = 0; i < 4; i++) {
				int nx = ice.x + dx[i];
				int ny = ice.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(!visited[nx][ny] && grid[nx][ny] == 0) {
						seaCount++;
					}
				}
			}
			
			if(grid[ice.x][ice.y] - seaCount < 0) {
				grid[ice.x][ice.y] = 0;
			}
			else {
				grid[ice.x][ice.y] -= seaCount;
			}
		}
	}

}

class Ice{
	int x;
	int y;
	
	public Ice(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
