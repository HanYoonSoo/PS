
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int grid[][];
	static int M;
	static int N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		
		dp = new int[M][N];
		grid = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			temp = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(temp[j]);
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	public static int dfs(int x, int y) {
		if(x == M - 1 && y == N - 1) {
			return 1;
		}
		
		if(dp[x][y] != -1)
			return dp[x][y];
		
		dp[x][y] = 0;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < M && ny >= 0 && ny < N &&  grid[nx][ny] < grid[x][y]) {
				dp[x][y] += dfs(nx, ny);
			}
		}
		
		return dp[x][y];
		
	}
}
