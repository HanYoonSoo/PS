import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<Integer>[] tree = new ArrayList[N];
        int[] cats = new int[T];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            tree[a].add(b);
            tree[b].add(a);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < T; i++){
            cats[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        dp[cats[0]] = 1;

        for(int i = 1; i < T; i++){
            int[] newDp = new int[N];
            Arrays.fill(newDp, Integer.MIN_VALUE);

            for(int j = 0; j < N; j++){
                newDp[j] = Math.max(newDp[j], dp[j] + (cats[i] == j ? 1 : 0));

                for(int next : tree[j]){
                    newDp[next] = Math.max(newDp[next], dp[j] + (cats[i] == next ? 1 : 0));
                }
            }

            dp = newDp;
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[i]);
//            System.out.println(dp[i]);
        }

        System.out.println(max);
    }
}
