import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X;
    static int[] arr;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int idx, int count){
        if(count >= 2) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sum += arr[i];
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i]);
                }
            }

            if (Math.abs(min - max) >= X && sum >= L && sum <= R) {
                result++;
            }

//            System.out.println(sum);

        }


        for(int i = idx; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}
