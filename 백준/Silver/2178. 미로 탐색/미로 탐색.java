
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] grid;
	static boolean[][] visited;
	static int[][] distance;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
 	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		
		grid = new int[N][M];
		visited = new boolean[N][M];
		distance = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] temp = scan.nextLine().split("");
			for(int j = 0;  j < temp.length; j++) {
				grid[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		System.out.println(bfs(0, 0));
	}
	
	public static int bfs(int x, int y) {
		visited[x][y] = true;
		distance[x][y] = 1;
		Queue<MPoint> queue = new LinkedList<>();
		
		queue.add(new MPoint(x, y));
		
		while(!queue.isEmpty()) {
			MPoint temp = queue.poll();
			
			if(temp.x == N-1 && temp.y == M-1) {
				return distance[N-1][M-1];
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == false && grid[nx][ny] == 1) {
					distance[nx][ny] = distance[temp.x][temp.y] + 1;
					queue.add(new MPoint(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		return 0;
	}
}

class MPoint{
	int x;
	int y;
	
	public MPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
