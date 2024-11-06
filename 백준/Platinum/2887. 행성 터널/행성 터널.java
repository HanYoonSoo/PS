import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] planet;
    static int[] parent;
    static List<int[]> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        planet = new int[N][4];
        parent = new int[N];
        graph = new ArrayList<>();

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planet[i][0] = x;
            planet[i][1] = y;
            planet[i][2] = z;
            planet[i][3] = i;
            parent[i] = i;
        }

        int idx = 0;
        for(int i = 0; i < 3; i++){
            int finalIdx = idx;
            Arrays.sort(planet, (o1, o2) -> o1[finalIdx] - o2[finalIdx]);
            idx++;

            for(int j = 0; j < N - 1; j++){
                graph.add(new int[]{planet[j][3], planet[j + 1][3], Math.abs(planet[j][finalIdx] - planet[j + 1][finalIdx])});
            }
        }

        Collections.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        long result = 0;
        for(int[] curr : graph){
            if(find_parent(curr[0]) != find_parent(curr[1])){
                union(curr[0], curr[1]);
                result += curr[2];
            }
        }

        System.out.println(result);
    }

    public static int find_parent(int p){
        if(parent[p] == p)
            return p;

        parent[p] = find_parent(parent[p]);

        return parent[p];
    }

    public static void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);

        if(a < b){
            parent[b] = a;
        } else{
            parent[a] = b;
        }
    }
}
