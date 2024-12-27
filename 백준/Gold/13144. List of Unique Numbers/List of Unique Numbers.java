import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[100001];
        int p1 = 0, p2 = 0;
        long result = 0;

        while (p1 < N) {
            while (p2 < N && !visited[arr[p2]]) {
                visited[arr[p2]] = true;
                p2++;
            }

            result += p2 - p1;

            visited[arr[p1]] = false;
            p1++;
        }

        System.out.println(result);
    }
}
