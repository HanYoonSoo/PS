import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] grid;
    static boolean[] visited;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
    }

    public static void dfs(int idx) {
        if (idx == N) {
            List<Integer> link = new ArrayList<>();
            List<Integer> start = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    link.add(i);
                } else {
                    start.add(i);
                }
            }

            int linkSum = 0;
            for (int i = 0; i < link.size() - 1; i++) {
                int idx1 = link.get(i);
                for (int j = i + 1; j < link.size(); j++) {
                    int idx2 = link.get(j);
                    linkSum += (grid[idx1][idx2] + grid[idx2][idx1]);
                }
            }

            int startSum = 0;
            for (int i = 0; i < start.size() - 1; i++) {
                int idx1 = start.get(i);
                for (int j = i + 1; j < start.size(); j++) {
                    int idx2 = start.get(j);
                    startSum += (grid[idx1][idx2] + grid[idx2][idx1]);
                }
            }

            max = Math.min(max, Math.abs(linkSum - startSum));
            return;
        }

        visited[idx] = true;
        dfs(idx + 1);
        visited[idx] = false;
        dfs(idx + 1);
    }
}
