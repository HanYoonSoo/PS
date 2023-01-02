
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
	static int N, M;
	static int maxSize;
	static int[][] grid;
	static int[][] wall;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int[] dir = {1, 2, 4, 8};
	static List<Integer> space = new ArrayList<>();
	static Map<Integer, Set<Integer>> side = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		M = Integer.parseInt(temp[0]);
		N = Integer.parseInt(temp[1]);
		
		grid = new int[N][M];
		wall = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				wall[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		int num = 1;
		int room = 0;
		
		maxSize = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] == 0) {
					bfs(i, j, num);
					num++;
					room++;
				}
			}
		}
		
		System.out.println(room);
		System.out.println(maxSize);
		
		int sum = 0;
		
		for(int i = 1; i <= room; i++) {
			if(side.get(i) != null) {
				for(int j : side.get(i)) {
					sum = Math.max(space.get(i-1) + space.get(j-1), sum);
				}
			}
		}
		
		System.out.println(sum);
		
	}
	
	public static void bfs(int x, int y, int num) {
		Queue<CNode> q = new LinkedList<>();
		
		q.add(new CNode(x, y));
		int count = 0;
		
		grid[x][y] = num;
		Set<Integer> set = new HashSet<>();
		
		while(!q.isEmpty()) {
			CNode node = q.poll();
			count++;
			//System.out.println(node.x + " " + node.y + " " + num);
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				
				if(grid[nx][ny] != 0 && grid[nx][ny] != num) {
					set.add(grid[nx][ny]);
					continue;
				}
				
				if((wall[node.x][node.y] & dir[i]) == 0 && grid[nx][ny] == 0) {
					q.add(new CNode(nx, ny));
					grid[nx][ny] = num;
					continue;
				}
			}
		}
		//System.out.println(count);
		side.put(num, set);
		space.add(count);
		maxSize = Math.max(maxSize, count);
	}
}

class CNode{
	int x;
	int y;
	
	public CNode(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
