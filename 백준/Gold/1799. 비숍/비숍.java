import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int grid[][];
    public static int[] dx = {-1, 1, -1, 1};
    public static int[] dy = {-1, -1, 1, 1};
    public static boolean[] visited;
    public static int[] result = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N * N];

        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split(" ");

            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dfs(0, 0, 0);
        dfs(1, 1, 0);
        System.out.println(result[0] + result[1]);

        System.out.println();

    }

    public static void dfs(int idx, int c, int count){
        if(idx >= N * N || (N * N - idx + 1 + count) <= result[c]){
            return;
        }

        result[c] = Math.max(result[c], count);
        int x = (int)idx / N;
        int y = idx % N;

        int j = y;

        for(int i = x; i < N; i++){
            while(j < N){
                int v = i * N + j;

                if(!visited[v] && grid[i][j] == 1 && check(v)){
                    visited[v] = true;
                    dfs(v, c, count + 1);
                    visited[v] = false;
                }

                j += 2;
            }

            if(i % 2 == 0){
                j = (c + 1) % 2;
            }
            else{
                j = c;
            }
        }
    }

    public static boolean check(int idx){
        int i = (int)idx / N;
        int j = idx % N;

        for(int d = 0; d < 4; d++){
            int x = i + dx[d];
            int y = j + dy[d];

            while(0 <= x && x < N && 0 <= y && y < N){
                if(visited[x * N + y]){
                    return false;
                }

                x += dx[d];
                y += dy[d];
            }
        }

        return true;
    }
}
