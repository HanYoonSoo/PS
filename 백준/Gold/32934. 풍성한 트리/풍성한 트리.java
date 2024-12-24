import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static int compareDist;
    static boolean compare;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        List<Integer> possibleRoot = new ArrayList<>();

        // 모든 차수가 1 또는 3이어야 한다.
        // 루트 노드의 차수는 3이다.
        for(int i = 1; i <= N; i++){
            if(graph.get(i).size() != 1 && graph.get(i).size() != 3){
                System.out.println(-1);
                return;
            } else if(graph.get(i).size() == 3){
                possibleRoot.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < possibleRoot.size(); i++){
            int root = possibleRoot.get(i);

            compare = false;
            compareDist = -1;
            dfs(root, -1, 0);

            if(!compare){
                result.add(root);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(result.isEmpty()){
            sb.append(-1);
        } else{
            sb.append(result.size()).append("\n");
            for(int i = 0; i < result.size(); i++){
                sb.append(result.get(i) + " ");
            }
        }

        System.out.println(sb);
    }

    public static void dfs(int root, int parent, int dist){
        if(compare){
            return;
        }

        if(graph.get(root).size() == 1){
            if(compareDist == -1){
                compareDist = dist;
            } else if(compareDist != dist){
                compare = true;
            }

            return;
        }

        for(int node : graph.get(root)){
            if(node != parent){
                dfs(node, root, dist + 1);
                if(compare){
                    return;
                }
            }
        }
    }
}
