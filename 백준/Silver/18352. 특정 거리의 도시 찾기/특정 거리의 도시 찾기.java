import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1번부터 N번까지의 도시와 M개의 단방향 도로
// 모든 도로의 거리는 1
// 최단 거리가 정확히 K인 도시들의 번호 출력
// 오름차순으로 출력
public class Main {

    static int N, M, K, X;
    static List<Integer>[] graph;
    static List<Integer> result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        result = new ArrayList<>();
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        bfs();

        if(result.size() == 0){
            System.out.println(-1);
        }else{
            Collections.sort(result);

            for(Integer i : result){
                System.out.println(i);
            }
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(X, 0));
        visited[X] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.distance > K){
                break;
            }
            
            if(curr.distance == K){
                if(!result.contains(curr.end))
                    result.add(curr.end);
            }

            for(Integer i : graph[curr.end]){
                if(!visited[i]){
                    q.add(new Node(i, curr.distance + 1));
                    visited[i] = true;
                }
            }
        }
    }


    static class Node implements Comparable<Node>{
        int end;
        int distance;

        public Node(int end, int distance){
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }
}
