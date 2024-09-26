import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][] grid;
    static boolean[] visited;
    static List<int[]> mint;
    static int start_y, start_x;
    static int result = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        mint = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());

                if(grid[i][j] == 1){
                    start_y = i;
                    start_x = j;
                } else if(grid[i][j] == 2){
                    mint.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[mint.size()];

        dfs(start_y, start_x, 0, M);

        System.out.println(result);
    }

    public static void dfs(int y, int x, int count, int health){
        if((Math.abs(y - start_y) + Math.abs(x - start_x)) <= health){
            result = Math.max(result, count);
        }

        for(int i = 0; i < mint.size(); i++){
            if(!visited[i]){
                int[] curr = mint.get(i);
                if(health >= (Math.abs(curr[0] - y) + Math.abs(curr[1] - x))) {
                    visited[i] = true;
                    dfs(curr[0], curr[1], count + 1, health - (Math.abs(curr[0] - y) + Math.abs(curr[1] - x)) + H);
                    visited[i] = false;
                }
            }
        }
    }
}

