import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, M;

    static List<ArrayList<Integer>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");

        graph = new ArrayList<>();
        dist = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++){
            int num = Integer.parseInt(temp[i]);
            graph.get(num).add(i + 1);
        }

        for(int i = 0; i < M; i++){
            temp = br.readLine().split(" ");

            int start = Integer.parseInt(temp[0]);
            int w = Integer.parseInt(temp[1]);

            dist[start] += w;
        }

        dfs(1,0);

        for(int i = 1; i <= N; i++){
            System.out.print(dist[i] + " ");
        }


    }

    public static void dfs(int start, int w){
        dist[start] += w;
        for(int next : graph.get(start)){
            dfs(next, dist[start]);
        }
    }
}
