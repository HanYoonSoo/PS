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

    static class Node{
        int maxW;
        int totalDist;

        public Node(int maxW){
            this.maxW = maxW;
            totalDist = 0;
        }
    }

    static int N;
    static int M;
    static long C;
    static int A;
    static int B;

    static List<List<Edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        C = Long.parseLong(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, w));
            graph.get(end).add(new Edge(start, w));
        }

        long left = 1;
        long right = C;

        long result = Long.MAX_VALUE;

        while(left <= right){
            long mid = (left + right) / 2;

//            System.out.println(left + " " + mid + " " + right);

            if(dijkstra(mid)){
                result = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }

        System.out.println(result == Long.MAX_VALUE ? -1 : result);
    }

    public static boolean dijkstra(long mid){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Node[] nodes = new Node[N + 1];

        for(int i = 1; i <= N; i++){
            nodes[i] = new Node(Integer.MAX_VALUE);
        }

        pq.add(new Edge(A, 0));
        nodes[A].maxW = 0;

//        int max = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            int node = curr.end;
            int w = curr.w;

            if(nodes[node].maxW < w){
                continue;
            }

            for(Edge edge : graph.get(node)){
                int compute = Math.max(edge.w, w);

                int total = nodes[node].totalDist + edge.w;

                if(total <= C && nodes[edge.end].maxW > compute){
                    nodes[edge.end].maxW = compute;
                    nodes[edge.end].totalDist = total;
                    pq.add(new Edge(edge.end, compute));
                }
            }
        }

//        System.out.println(nodes[B].maxW + " " + nodes[B].totalDist);
        return nodes[B].maxW <= mid && nodes[B].totalDist <= C;
    }
}
