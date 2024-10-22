import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] guilty;
    static int N;
    static int[][] grid;
    static int mafia;
    static int result = 0;
    static boolean[] isDied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        guilty = new int[N];
        grid = new int[N][N];
        isDied = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            guilty[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mafia = Integer.parseInt(br.readLine());

        if (N % 2 == 0) {
            dfs(false, N, 0);
        } else {
            dfs(true, N, 0);
        }

        System.out.println(result);
    }

    public static void dfs(boolean day, int alive, int count) {
        result = Math.max(count, result);
        if (alive == 1) {
//            result = Math.max(count, result);
            return;
        }

        if (day) {
            int max = 0;
            int maxIdx = -1;
            for (int i = 0; i < N; i++) {
                if (!isDied[i]) {
                    if (max <= guilty[i]) {
                        if (max < guilty[i]) {
                            maxIdx = i;
                        }

                        max = guilty[i];
                    }
                }
            }

            if(maxIdx != mafia) {
                isDied[maxIdx] = true;
                dfs(false, alive - 1, count);
                isDied[maxIdx] = false;
            }

        } else {
            for (int i = 0; i < N; i++) {
                if (!isDied[i] && i != mafia) {
                    for (int j = 0; j < N; j++) {
                        guilty[j] += grid[i][j];
                    }
                    isDied[i] = true;
                    dfs(true, alive - 1, count + 1);
                    isDied[i] = false;
                    for (int j = 0; j < N; j++) {
                        guilty[j] -= grid[i][j];
                    }

                }
            }
        }
    }
}
