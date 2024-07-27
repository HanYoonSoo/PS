import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int start;
    static int target;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[start] = true;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start, 0});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int parent = curr[0];
            int count = curr[1];

            if(target == parent){
                System.out.println(count);
                System.exit(0);
            }
            for(int node : graph.get(parent)){
                if(!visited[node]){
                    visited[node] = true;
                    q.add(new int[]{node, count + 1});
                }
            }
        }

        System.out.println(-1);
    }
}
