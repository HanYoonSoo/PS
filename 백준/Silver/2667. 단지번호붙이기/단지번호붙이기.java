import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] grid;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split("");
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }

        visited = new boolean[N][N];


        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    result.add(bfs(i, j));
                }
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();

        sb.append(result.size() + "\n");

        for(int num : result){
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int a, int b){
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();

        visited[a][b] = true;
        int count = 0;
        q.add(new int[]{a, b});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            count++;

            int y = curr[0];
            int x = curr[1];

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && grid[ny][nx] == 1){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        return count;
    }
}
