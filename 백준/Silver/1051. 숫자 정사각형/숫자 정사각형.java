import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int maxSize = Math.min(N, M);

        grid = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        while(maxSize != 1){
            for(int i = 0; i <= N - maxSize; i++){
                for(int j = 0; j <= M - maxSize; j++){
                    if(isPossible(i, j, maxSize)){
                        System.out.println(maxSize * maxSize);
                        return;
                    }
                }
            }
            maxSize--;
        }

        System.out.println(1);
    }

    public static boolean isPossible(int i, int j, int size){
        if(grid[i][j] == grid[i + size - 1][j] && grid[i + size - 1][j] == grid[i][j + size - 1] && grid[i][j + size - 1] == grid[i + size - 1][j + size - 1]){
            return true;
        }

        return false;
    }
}
