import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 6
     * 2
     * 1 6 9 3 6 7
     *
     * 1 3 6 6 7 9
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        List<Integer> dists = new ArrayList<>();

        for(int i = 1; i < N; i++){
            dists.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(dists);

        int result = 0;

        for(int i = 0; i < N - K; i++){
            result += dists.get(i);
        }

        System.out.println(result);
    }
}
