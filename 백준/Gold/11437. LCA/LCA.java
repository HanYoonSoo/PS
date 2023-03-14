import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M;

    static List<ArrayList<Integer>> graph;
    static int[] parent;
    static int[] depth;

    public static void dfs(int from, int count){
        depth[from] = count++;

        for(int vertex : graph.get(from)){
            if(depth[vertex] == 0){
                dfs(vertex, count);
                parent[vertex] = from;
            }
        }
    }

    public static int find_parent(int a, int depth_a, int b, int depth_b){
        if(depth_a > depth_b){
            while(depth_a != depth_b){
                depth_a -= 1;
                a = parent[a];
            }
        }
        else if(depth_a < depth_b){
            while(depth_a != depth_b){
                depth_b -= 1;
                b = parent[b];
            }
        }

        while(a != b){
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        parent = new int[N + 1];
        depth = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            String[] temp = br.readLine().split(" ");

            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1, 1);

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            String[] temp = br.readLine().split(" ");

            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            System.out.println(find_parent(a, depth[a], b, depth[b]));
        }


    }
}
