import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static boolean[] visited;
    static List<ArrayList<Integer>> graph;
    static DNode[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        graph = new ArrayList<>();
        dp = new DNode[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
            dp[i] = new DNode(0, 0);
        }

        for(int i = 0; i < N - 1; i++){
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        System.out.println(Math.min(dp[1].me, dp[1].child));
    }

    public static void dfs(int start){
        visited[start] = true;

        if(graph.get(start).size() == 0){
            dp[start] = new DNode(0, 1);
        }
        else{
            for(int node : graph.get(start)){
                if(!visited[node]){
                    dfs(node);
                    dp[start].me += Math.min(dp[node].child, dp[node].me);
                    dp[start].child += dp[node].me;
                }
            }
            dp[start].me += 1;
        }
    }
}

class DNode{
    int child;
    int me;

    public DNode(int child, int me){
        this.child = child;
        this.me = me;
    }
}
