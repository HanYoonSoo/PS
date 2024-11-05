import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] good;
    static List<List<Integer>> edge;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        good = new int[N + 1];
        edge = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; i++) {
            edge.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            good[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge.get(a).add(b);
            edge.get(b).add(a);
        }

        dfs(1, -1);

        System.out.println(answer);
    }

    private static int dfs(int cur, int parent) {
        List<Integer> v = new ArrayList<>();

        for (int next : edge.get(cur)) {
            if (next == parent) continue;

            int val = dfs(next, cur);
            if (val > 0) {
                v.add(val);
            }
        }

        Collections.sort(v);

        int ret = good[cur];
        
        for (int i = 0; i < v.size(); i++) {
            if (ret + v.get(i) > K) {
                answer += v.size() - i;
                break;
            }
            ret += v.get(i);
        }

        return ret;
    }
}
