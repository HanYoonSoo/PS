import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        dfs(new ArrayList<>());
    }

    public static void dfs(List<Integer> result){
        if(result.size() == N){
            for(int num : result){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                result.add(i);
                dfs(result);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }
}
