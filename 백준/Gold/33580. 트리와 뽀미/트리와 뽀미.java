import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] cats = new int[t];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            cats[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        long[] dp = new long[n];
        Arrays.fill(dp, Long.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            dp[i] = (cats[0] == i) ? 1 : 0;
        }

        for (int time = 1; time < t; time++) {
            long[] dpNew = new long[n];
            Arrays.fill(dpNew, Long.MIN_VALUE);

            for (int i = 0; i < n; i++) {
                if (dp[i] == Long.MIN_VALUE) {
                    continue;
                }

                dpNew[i] = Math.max(dpNew[i], dp[i] + (cats[time] == i ? 1 : 0));

                for (int j : graph.get(i)) {
                    dpNew[j] = Math.max(dpNew[j], dp[i] + (cats[time] == j ? 1 : 0));
                }
            }

            dp = dpNew;
        }

        long max = Arrays.stream(dp).max().getAsLong();
        out.write(max + "\n");

        out.flush();
        br.close();
        out.close();
    }
}
