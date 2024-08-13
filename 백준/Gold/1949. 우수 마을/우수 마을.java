import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        List<Integer> node;
        int total;

        public Node(int total){
            node = new ArrayList<>();
            this.total = total;
        }
    }

    static boolean[] visited;
    static Node[] tree;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            tree[i] = new Node(Integer.parseInt(st.nextToken()));
        }

        for(int i = 1; i <= N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].node.add(b);
            tree[b].node.add(a);
        }

        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    public static void dfs(int root){
        visited[root] = true;

        dp[root][0] = 0;
        dp[root][1] = tree[root].total;

        List<Integer> nodes = tree[root].node;

        for(int node : nodes) {
            if (!visited[node]) {
                dfs(node);

                dp[root][0] += Math.max(dp[node][1], dp[node][0]);
                dp[root][1] += dp[node][0];
            }
        }

//        System.out.println(root + " " + dp[root][0] + " " + dp[root][1]);
    }
}

//7
//100 1 1 100 1 1 100
//1 2
//2 3
//3 4
//3 5
//5 6
//5 7