import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] HI = new int[N];
        int[] ARC = new int[M];
        int[] count = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            HI[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ARC[i] = Integer.parseInt(st.nextToken());
            count[ARC[i]]++;
        }

        Arrays.sort(ARC);

        long hWin = 0;
        long aWin = 0;
        long same = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = M - 1;
            int lastWin = -1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (ARC[mid] < HI[i]) {
                    lastWin = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            hWin += (lastWin + 1);

            same += count[HI[i]];

            aWin += M - lastWin - 1 - count[HI[i]];
        }

        System.out.println(hWin + " " + aWin + " " + same);
    }
}
