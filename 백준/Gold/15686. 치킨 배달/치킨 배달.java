import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<int[]> chicken;
    static List<int[]> house;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    house.add(new int[]{i, j});
                } else if (num == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int idx, int count) {
        if (count == M) {
            int total = 0;
            for (int i = 0; i < house.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        min = Math.min(min, Math.abs(house.get(i)[0] - chicken.get(j)[0]) + Math.abs(house.get(i)[1] - chicken.get(j)[1]));
                    }
                }
                total += min;
            }
            result = Math.min(result, total);

            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}
