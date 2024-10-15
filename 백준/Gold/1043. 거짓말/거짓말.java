import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> human;
    static List<List<Integer>> party;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        human = new ArrayList<>();
        party = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            human.add(new ArrayList<>());
        }

        for(int i = 0; i <= M; i++){
            party.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        int[] know = new int[T];

        for(int i = 0; i < T; i++){
            know[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++){
                int person = Integer.parseInt(st.nextToken());
                party.get(i).add(person);
                human.get(person).add(i);
            }
        }

        visited = new boolean[M + 1];

        for(int i = 0; i < T; i++){
//            visited[know[i]] = true;
            dfs(know[i]);
        }

        int count = 0;
        for(int i = 1; i <= M; i++){
            if(!visited[i]){
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int person){
        for(int p : human.get(person)){
            if(!visited[p]){
                visited[p] = true;
                for(int h : party.get(p)){
                    dfs(h);
                }
            }
        }
    }
}
