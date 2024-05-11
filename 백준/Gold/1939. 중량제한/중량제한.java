import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /**
     * N(2 ≤ N ≤ 10,000)개의 섬으로 이루어진 나라가 있다.
     * 서로 같은 두 섬 사이에 여러 개의 다리가 있을 수도 있으며, 모든 다리는 양방향이다.
     * 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하는 프로그램을 작성하시오.
     * 첫째 줄에 N, M(1 ≤ M ≤ 100,000)이 주어진다.
     * 다음 M개의 줄에는 다리에 대한 정보를 나타내는 세 정수 A, B(1 ≤ A, B ≤ N), C(1 ≤ C ≤ 1,000,000,000)가 주어진다.
     * 마지막 줄에는 공장이 위치해 있는 섬의 번호를 나타내는 서로 다른 두 정수가 주어진다.
     *
     * 중요한 점.
     * 단순 BFS로 풀기에는 전체 탐색을 진행해야 하며
     * 우선순위 큐로 풀기에는 무조건 적으로 무거운걸 선택하면 다음 다리가 무너질 수 있음
     * 무게에 관한 이진 탐색이 필요.
     *
     * 입력)
     * 3 3
     * 1 2 2
     * 3 1 3
     * 2 3 2
     * 1 3
     */

    static int N;
    static int M;
    static int compare;
    static boolean[] visited;

    static List<List<Node>> graph;

    static class Node{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        int max = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(to).add(new Node(from, weight));
            graph.get(from).add(new Node(to, weight));

            max = Math.max(max, weight);
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = max;

        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            compare = -1;
            visited = new boolean[N + 1];
            dfs(start, end, visited, mid);

            if(compare != -1){
                result = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static void dfs(int start, int target, boolean[] visited, int limit){
        if(start == target){
            compare = start;
            return;
        }

        visited[start] = true;

        for(Node n : graph.get(start)){
            if(!visited[n.end] && n.weight >= limit){
                dfs(n.end, target, visited, limit);
            }
        }
    }
}
