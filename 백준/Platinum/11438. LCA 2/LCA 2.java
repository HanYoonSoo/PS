import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M, K;
    static int[] depth;
    static List<ArrayList<Integer>> tree;
    static int[][] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        K = 0;
        tree = new ArrayList<>();

        for(int i = 1; i <= N; i *= 2){
            K++;
        }

        depth = new int[N + 1];
        parent = new int[K][N + 1];

        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }


        for(int i = 0; i < N - 1; i++){
            String[] temp = br.readLine().split(" ");

            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1, 1);

        fill_parent();

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            String[] temp = br.readLine().split(" ");

            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            System.out.println(find_parent(a, b));
        }

    }

    public static void dfs(int start, int count){
        depth[start] = count++;

        for(int next : tree.get(start)){
            if(depth[next] == 0){
                dfs(next, count);
                parent[0][next] = start;
            }
        }
    }

    public static void fill_parent(){
        for(int i = 1; i < K; i++){
            for(int j = 1; j <= N; j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
    }

    public static int find_parent(int a, int b){
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        for(int i = K - 1; i >= 0; i--){
            if(Math.pow(2, i) <= depth[a] - depth[b]){
                a = parent[i][a];
            }
        }

        if(a == b){
            return a;
        }

        int k = K-1;

        for(int i = K - 1; i >= 0; i--){
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        return parent[0][a];
    }
}
