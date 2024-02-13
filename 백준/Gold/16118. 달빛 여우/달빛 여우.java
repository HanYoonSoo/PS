import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 달빛 여우, 달빛 늑대 존재
// N개의 그루터기, M개의 오솔길(양방향, 그루터기 사이 오솔킬 최대 2개)
// 시작점은 1번 그루터기
// 그루터기들 중 하나가 달빛을 받아 밝게 빛남
// 달빛 여우는 일정한 속도, 달빛 늑대는 출발시 여우의 2배 속도(그 다음 오솔길에선 여우의 절반 속도로 가다가 다시 2배)
// 각자 달빛이 비치는 그루터기까지 다다를 수 있는 최소 경로로 이동
// 둘의 이동경로가 다를 수 있음
public class Main {
    public static int N;
    public static int M;
    public static List<Edge>[] graph;
    public static int[] distFox;
    public static int[][] distWolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];

        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        distFox = new int[N];
        distWolf = new int[2][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken()) - 1;
            int from = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());

            graph[to].add(new Edge(from, distance * 2)); // 나중에 계산하기 편하게 하기 위해 2배 처리(소수점)
            graph[from].add(new Edge(to, distance * 2));
        }

        Arrays.fill(distFox, Integer.MAX_VALUE);
        Arrays.fill(distWolf[0], Integer.MAX_VALUE);
        Arrays.fill(distWolf[1], Integer.MAX_VALUE);

        wolfDijkstra();
        foxDijkstra();

        int result = 0;
        for(int i = 0; i < N; i++){
            if(distFox[i] < Math.min(distWolf[0][i], distWolf[1][i])){
                result++;
            }
        }

        System.out.println(result);
    }

    // Wolf 다익스트라 알고리즘 수행을 위한 함수
    public static void wolfDijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0, 0));

        distWolf[0][0] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(distWolf[curr.oddEven][curr.end] < curr.weight){
                continue;
            }

            for(Edge edge : graph[curr.end]){
                int node = edge.end;
                int weight = curr.weight;
                int oddEven = 0;

                if(curr.oddEven == 0){
                    weight += edge.weight / 2;
                    oddEven = 1;
                }
                else{
                    weight += edge.weight * 2;
                    oddEven = 0;
                }

                if(distWolf[oddEven][node] > weight){
                    distWolf[oddEven][node] = weight;
                    pq.add(new Edge(node, weight, oddEven));
                }
            }
        }
    }

    // Fox 다익스트라 알고리즘 수행을 위한 함수
    public static void foxDijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        distFox[0] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(distFox[curr.end] < curr.weight){
                continue;
            }

            for(Edge edge : graph[curr.end]){
                int node = edge.end;
                int weight = curr.weight + edge.weight;

                if(distFox[node] > weight){
                    distFox[node] = weight;
                    pq.add(new Edge(node, weight));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int end;
        int weight;
        int oddEven;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public Edge(int end, int weight, int oddEven) {
            this.end = end;
            this.weight = weight;
            this.oddEven = oddEven;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}

