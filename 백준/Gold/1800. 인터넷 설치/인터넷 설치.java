import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{
        int end;
        int w;

        public Edge(int end, int w){
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e){
            return this.w - e.w;
        }
    }

    static List<List<Edge>> graph = new ArrayList<>();
    static int N;
    static int P;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        int max = 0;

        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));

            max = Math.max(w, max);
        }

        int left = 0;
        int right = max;
        int result = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(bfs(mid)){
                result = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static boolean bfs(int mid){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Edge(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            int node = curr.end;
            int over = curr.w;

            if(over > dist[node]){
                continue;
            }

            for(Edge edge : graph.get(node)){
                int nextOver = over;

                if(edge.w > mid){
                    nextOver++;
                }

                if(dist[edge.end] > nextOver){
                    dist[edge.end] = nextOver;
                    pq.add(new Edge(edge.end, nextOver));
                }
            }
        }

//        System.out.println(mid + " " + dist[N]);

        return dist[N] <= K;
    }
}
