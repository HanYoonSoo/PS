import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split("");
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(arr[j]);
            }
        }

        visited[0][0] = true;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int y = curr[0];
            int x = curr[1];
            int count = curr[2];

            if(y == (N - 1) && x == (M - 1)){
                System.out.println(count);
                break;
            }

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && grid[ny][nx] == 1){
                    q.add(new int[]{ny, nx, count + 1});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
