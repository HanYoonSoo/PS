import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + k];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i < N + k; i++) {
            arr[i] = arr[i - N];
        }

        int p1 = 0;
        int p2 = -1;

        int[] count = new int[d + 1];
        int distinct = 0;
        int maxDistinct = 0;

        while (p1 < N) {
            if ((p2 - p1 + 1) < k) {
                p2++;
                int in = arr[p2];
                if (count[in] == 0) distinct++;
                count[in]++;
            } else {
                int cur = distinct + (count[c] == 0 ? 1 : 0);
                if (cur > maxDistinct) maxDistinct = cur;

                int out = arr[p1];
                count[out]--;
                if (count[out] == 0) distinct--;

                p1++;
            }
        }

        System.out.println(maxDistinct);
    }
}
