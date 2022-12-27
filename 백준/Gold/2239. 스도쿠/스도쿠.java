
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[][] grid;
	static List<int[]> zero;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		grid = new int[9][9];
		zero = new ArrayList<>();
		
		for(int i = 0; i < 9; i++) {
			String temp = br.readLine();
			for(int j = 0; j < 9; j++) {
				grid[i][j] = temp.charAt(j) - '0';
				
				if(grid[i][j] == 0) {
					zero.add(new int[] {i, j});
				}
			}
		}
		
		sudoku(0);
	}
	
	public static void sudoku(int depth) {
		if(zero.size() == depth) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int x = zero.get(depth)[0];
		int y = zero.get(depth)[1];
		
		boolean[] check = new boolean[10];
		
		for(int i = 0; i < 9; i++) {
			if(grid[x][i] != 0) {
				check[grid[x][i]] = true;
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(grid[i][y] != 0) {
				check[grid[i][y]] = true;
			}
		}
		
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		
		for(int i = startX; i < startX + 3; i++) {
			for(int j = startY; j < startY + 3; j++) {
				if(grid[i][j] != 0) {
					check[grid[i][j]] = true;
				}
			}
		}
		
		for(int i = 1; i <= 9; i++) {
			if(!check[i]) {
				grid[x][y] = i;
				sudoku(depth + 1);
				grid[x][y] = 0;
			}
		}
	}
}
