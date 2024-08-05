import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++){
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                graph.get(i + 1).add(Integer.parseInt(st.nextToken()));
            }
        }

//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//
//        while(!q.isEmpty()){
//            Integer curr = q.poll();
//
//            for(int node : graph.get(curr)){
//                if(!visited[curr][node]){
//                    q.add(node);
//                    visited[curr][node] = true;
//                } else{
//                    if(visited[node][curr]) {
//                        System.out.println("CYCLE");
//                        System.exit(0);
//                    }
//                }
//            }
//        }
//
//        System.out.println("NO CYCLE");

        if(dfs(graph, 1, visited, N)){
            System.out.println("NO CYCLE");
        }else{
            System.out.println("CYCLE");
        }

    }

    public static boolean dfs(List<List<Integer>> graph, int start, boolean[] visited, int end){
        if(start == end){
            return true;
        }

        visited[start] = true;

        // boolean compare = true;

        for(int node : graph.get(start)){
            if(visited[node]){
                return false;
            }

            if(!dfs(graph, node, visited, end)){
                return false;
            }
        }

        visited[start] = false;

        return true;
    }
}
