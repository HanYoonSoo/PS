
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static String[][] grid;
	static boolean[] visited = new boolean[26];
	static int R;
	static int N;
	static int result;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		R = scan.nextInt();
		N = scan.nextInt();
		
		scan.nextLine();
		
		grid = new String[R][N];
		
		for(int i = 0; i < R; i++) {
			String[] temp = scan.nextLine().split("");
			for(int j = 0; j < N; j++) {
				grid[i][j] = temp[j];
			}
		}
		
		result = 0;
		alpha(0, 0, 0);
		
		System.out.println(result);
	}
	
	public static void alpha(int x, int y, int count) {
		if(visited[grid[x][y].charAt(0) - 'A']) {
			result = Math.max(result,  count);
			return;
		}
		else {
			visited[grid[x][y].charAt(0) - 'A'] = true;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < R && ny >= 0 && ny < N) {
					alpha(nx, ny, count + 1);
				}
			}
			
			visited[grid[x][y].charAt(0) - 'A'] = false;
			
		}
	}
	
	
	
}
