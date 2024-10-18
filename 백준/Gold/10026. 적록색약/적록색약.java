import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String[][] grid;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new String[N][N];

        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split("");
            grid[i] = arr;
        }

        int area = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j, grid[i][j]);
                    area++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j].equals("G"))
                    grid[i][j] = "R";
            }
        }

        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i], false);
        }

        int area2 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j, grid[i][j]);
                    area2++;
                }
            }
        }

        System.out.println(area + " " + area2);



    }

    public static void bfs(int y, int x, String s){
        visited[y][x] = true;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{y, x});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int i = 0; i < 4; i++){
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]){
                    if(grid[ny][nx].equals(s)) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}

//5
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR