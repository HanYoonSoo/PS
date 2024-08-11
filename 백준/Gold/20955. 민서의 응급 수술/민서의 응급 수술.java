import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] parent = new int[N + 1];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        int result = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find_parent(parent, a) != find_parent(parent, b)){
                union(parent, a, b);
            } else{
                result++;
            }
        }

        for(int i = 1; i <= N - 1; i++){
            if(find_parent(parent, i) != find_parent(parent, i + 1)){
                union(parent, i, i + 1);
                result++;
            }
        }

        System.out.println(result);
    }

    public static int find_parent(int[] parent, int p){
        if(parent[p] == p)
            return parent[p];

        p = find_parent(parent, parent[p]);

        return p;
    }

    public static void union(int[] parent, int a, int b){
        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if(a < b){
            parent[b] = parent[a];
        } else{
            parent[a] = parent[b];
        }
    }
}
