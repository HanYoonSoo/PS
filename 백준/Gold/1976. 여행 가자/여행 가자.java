import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        int[] parent = new int[N];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            parent[i] = i;
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] == 1){
                    if(find_parent(i, parent) != find_parent(j, parent)){
                        union(i, j, parent);
                    }
                }
            }
        }


        String[] check = br.readLine().split(" ");

        for(int i = 0; i < M - 1; i++){
            int a = Integer.parseInt(check[i]) - 1;
            int b = Integer.parseInt(check[i + 1]) - 1;

            if(find_parent(a, parent) != find_parent(b, parent)){
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }

    private static void union(int a, int b, int[] parent) {
        a = find_parent(a, parent);
        b = find_parent(b, parent);

        if(a < b){
            parent[b] = a;
        } else{
            parent[a] = b;
        }
    }

    private static int find_parent(int p, int[] parent) {
        if(parent[p] == p)
            return p;

        parent[p] = find_parent(parent[p], parent);

        return parent[p];
    }


}
