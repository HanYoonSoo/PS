import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][][] visited = new boolean[61][61][61];

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] scv = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N; i < 3; i++){
            scv[i] = 0;
        }
        
        Arrays.sort(scv);

        dfs(scv[2], scv[1], scv[0], 0);

        System.out.println(result);
    }

    public static void dfs(int a, int b, int c, int count) {
        a = Math.max(a, 0);
        b = Math.max(b, 0);
        c = Math.max(c, 0);

        if(a == 0 && b == 0 && c == 0){
            result = Math.min(result, count);
            return;
        }

        if(result < count){
            return;
        }

        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);

        c = arr[0];
        b = arr[1];
        a = arr[2];

        if(visited[a][b][c]){
            return;
        } else {
            visited[a][b][c] = true;
        }

        dfs(a - 9, b - 3, c - 1, count + 1);
        dfs(a - 9, b - 1, c - 3, count + 1);
        dfs(a - 3, b - 9, c - 1, count + 1);
        dfs(a - 3, b - 1, c - 9, count + 1);
        dfs(a - 1, b - 3, c - 9, count + 1);
        dfs(a - 1, b - 9, c - 3, count + 1);
    }
}
