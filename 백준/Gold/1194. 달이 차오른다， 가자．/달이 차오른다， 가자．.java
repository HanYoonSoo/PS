
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static int ans;
	static char[][] grid;
	static boolean[][][] visited;
	static KNode start;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		grid = new char[N][M];
		visited = new boolean[64][N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				grid[i][j] = str.charAt(j);
				if(grid[i][j] == '0') {
					start = new KNode(i, j, 0, 0);
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<KNode> q = new LinkedList<>();
		q.add(new KNode(start.x, start.y, 0, 0));
		visited[0][start.x][start.y] = true;
		
		while(!q.isEmpty()) {
			KNode node = q.poll();
			int x = node.x;
			int y = node.y;
			int dist = node.dist;
			int key = node.key;
			
			if(grid[x][y] == '1') {
				return dist;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isValid(nx, ny) && grid[nx][ny] != '#' && !visited[key][nx][ny]) {
					if(grid[nx][ny] == '.' || grid[nx][ny] == '0' || grid[nx][ny] == '1') {
						visited[key][nx][ny] = true;
						q.offer(new KNode(nx, ny, dist + 1, key));
					}
					else if(grid[nx][ny] >= 'a' && grid[nx][ny] <= 'f') {
						int newkey = 1 << (grid[nx][ny] - 'a');
						newkey = newkey | key;
						if(!visited[newkey][nx][ny]) {
							visited[key][nx][ny] = true;
							visited[newkey][nx][ny] = true;
							q.offer(new KNode(nx, ny, dist + 1, newkey));
						}
					}
					else if(grid[nx][ny] >= 'A' && grid[nx][ny] <= 'F') {
						int door = 1 << (grid[nx][ny] - 'A');
						if((key & door) > 0) {
							visited[key][nx][ny] = true;
							q.offer(new KNode(nx, ny, dist + 1, key));
						}
					}
				}
			}
		}
		return -1;
	}
	
	public static boolean isValid(int nx, int ny) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
			return false;
		}
		return true;
	}
}

class KNode{
	int x;
	int y;
	int dist;
	int key;
	
	public KNode(int x, int y, int dist, int key) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.key = key;
	}
}