import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] grid = new boolean[50][50];
    static int N;
    static int[] dy = {-1, -1, -1, 1, 1, 1};
    static int[] dx = {0, -1, 1, 0, -1, 1};
    static int[][] nextMove = {{1, 2}, {0, 4}, {0, 5}, {4, 5}, {3, 1}, {3, 2}};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid[25][25] = true;

        dfs(0, 0, 24, 25);

        System.out.println(answer);
    }

    public static void dfs(int count, int prevIdx, int y, int x){
//        if(grid[y][x]){
//            if(count == N){
//                answer++;
//            }
//
//            return;
//        }

        if(count == N){
            if(grid[y][x]){
                answer++;
            }

            return;
        }

        if(grid[y][x]){
            return;
        }

        grid[y][x] = true;

        for(int i = 0; i < 2; i++){
            dfs(count + 1, nextMove[prevIdx][i], y + dy[nextMove[prevIdx][i]], x + dx[nextMove[prevIdx][i]]);
        }

        grid[y][x] = false;
    }
}
