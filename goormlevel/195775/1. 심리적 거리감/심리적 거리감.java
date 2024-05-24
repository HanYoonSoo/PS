import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
        }

//        findResult();

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{K, 0});

        boolean[] visited = new boolean[N + 1];

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[K] = 0;
        visited[K] = true;

        int maxDist = 0;
        int maxG = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int count = curr[1];

            for(int n : graph.get(node)){
                if(!visited[n]){
                    dist[n] = Math.abs(K - n) + (count + 1);
                    if(maxDist == dist[n]){
                        maxG = Math.max(maxG, n);
                    }

                    if(maxDist < dist[n]){
                        maxDist = dist[n];
                        maxG = n;
                    }
                    q.add(new int[]{n, count + 1});
                    visited[n] = true;
                }
            }
        }

        boolean compare = true;
        for(int i = 1; i <= N; i++){
            if(i == K)
                continue;
            if(dist[i] != Integer.MAX_VALUE){
                compare = false;
                break;
            }
        }

        if(!compare) {
            System.out.println(maxG);
        }
        else{
            System.out.println(-1);
        }
    }

//    private static void findResult() {
//        PriorityQueue<int[]> pq = new PriorityQueue<>();
//        int[] dist = new int[N + 1];
//        boolean[] visited = new boolean[N + 1];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//
//        dist[K] = 0;
//        visited[K] = true;
//        pq.add(new int[]{K, 0});
//
//        while(!pq.isEmpty()){
//            int[] curr = pq.poll();
//            int node = curr[0];
//            int distance = curr[1];
//
//            for(int n : graph.get(node)){
//                int compute = Math.abs(node - n);
//
//                if(dist[n] > dist[node] + distance){
//                    dist[n] = dist[node] + distance + 1 + compute;
//                }
//            }
//        }
//    }
}
