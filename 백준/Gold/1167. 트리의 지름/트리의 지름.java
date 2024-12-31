import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge{
        int end;
        int w;

        public Edge(int end, int w){
            this.end = end;
            this.w = w;
        }

    }

    static List<Edge>[] tree;
    static int result = 0;
    static int fallNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];


        for(int i = 1; i <= N; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());

            int v1;
            while((v1 = Integer.parseInt(st.nextToken())) != -1){
                int dist = Integer.parseInt(st.nextToken());

                tree[node].add(new Edge(v1, dist));
            }
        }

        dfs(1, -1, 0);
        dfs(fallNode, -1, 0);
        
        System.out.println(result);
    }

    public static void dfs(int root, int parent, int dist){
        if(parent != -1 && tree[root].size() == 1){
            if(result < dist){
                result = dist;
                fallNode = root;
            }
            return;
        }

        for(Edge edge : tree[root]){
            if(edge.end != parent){
                dfs(edge.end, root, dist + edge.w);
            }
        }
    }
}
