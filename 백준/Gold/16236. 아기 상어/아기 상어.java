
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int n;
	static int[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		grid = new int[n][n];
		Queue<FNode> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				if(temp[j].equals("9")) {
					grid[i][j] = 0;
					q.add(new FNode(i, j, 0));
				}
				else {
					grid[i][j] = Integer.parseInt(temp[j]);
				}
			}
		}
		
		int time = 0;
		int eat = 0;
		int size = 2;
		
		while(true) {
			List<FNode> fish = new LinkedList<>();
			int[][] dist = new int[n][n];
			
			while(!q.isEmpty()) {
				FNode current = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = current.x + dx[i];
					int ny = current.y + dy[i];
					
					if(nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] == 0 && grid[nx][ny] <= size) {
						dist[nx][ny] = current.dist + 1;
						q.add(new FNode(nx, ny, dist[nx][ny]));
						
						if(1 <= grid[nx][ny] && grid[nx][ny] <= 6 && grid[nx][ny] < size) {
							fish.add(new FNode(nx, ny, dist[nx][ny]));
						}
					}
				}
			}
			
			if(fish.size() == 0) {
				System.out.println(time);
				return;
			}
			
			FNode currentFish = fish.get(0);
			
			for(int i = 1; i < fish.size(); i++) {
				if(currentFish.dist > fish.get(i).dist) {
					currentFish = fish.get(i);
				}
				else if(currentFish.dist == fish.get(i).dist) {
					if(currentFish.x > fish.get(i).x)
						currentFish = fish.get(i);
					else if(currentFish.x == fish.get(i).x) {
						if(currentFish.y > fish.get(i).y)
							currentFish = fish.get(i);
					}
				}
			}
			
			time += currentFish.dist;
			eat++;
			if(eat == size) {
				size++;
				eat = 0;
			}
			grid[currentFish.x][currentFish.y] = 0;
			q.add(new FNode(currentFish.x, currentFish.y, 0));
		}
	}
}

class FNode{
	int x;
	int y;
	int dist;
	
	public FNode(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
