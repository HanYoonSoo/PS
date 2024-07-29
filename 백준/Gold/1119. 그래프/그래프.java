import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            System.exit(0);
        }

        graph = new ArrayList<>();
        visited = new boolean[N];
        
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        int total = 0;
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++){
                if(str[j].equals("Y")) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                    total++;
                }
            }
        }

        total /= 2;

        List<Integer> teamCount = new ArrayList<>();

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                teamCount.add(dfs(i));
            }
        }

        int minEdge = 0;

        for(int team : teamCount){
            minEdge += team - 1;

            if(team == 1){
                System.out.println(-1);
                System.exit(0);
            }
        }

        if(teamCount.size() - 1 <= total - minEdge){
            System.out.println(teamCount.size() - 1);
        } else{
            System.out.println(-1);
        }

//        System.out.println((teamCount.size() - 1) + " " + (total - minEdge));
    }

    private static int dfs(int node) {
        int count = 1;

        for(int curr : graph.get(node)){
            if(!visited[curr]){
                visited[curr] = true;
                count += dfs(curr);
            }
        }

        return count;
    }
}
