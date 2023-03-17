import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, R, Q;
    static List<ArrayList<Integer>> tree;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        for(int i = 0; i < 3; i++){
            N = Integer.parseInt(temp[0]);
            R = Integer.parseInt(temp[1]);
            Q = Integer.parseInt(temp[2]);
        }

        tree = new ArrayList<>();
        dp = new int[N + 1];

        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(R);

        for(int i = 0; i < Q; i++){
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }

    public static int dfs(int root){
        if(dp[root] != 0){
            return dp[root];
        }

        dp[root] = 1;

        for(int next : tree.get(root)){
            if(dp[next] == 0) {
                dp[root] += dfs(next);
            }
        }

        return dp[root];
    }
}
