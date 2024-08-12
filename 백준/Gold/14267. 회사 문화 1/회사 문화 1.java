import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /**
     * 5 3
     * -1 1 2 3 4
     * 2 2
     * 3 4
     * 5 6
     */

    static List<List<Integer>> company;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        company = new ArrayList<>();
        scores = new int[N + 1];

        for(int i = 0; i <= N; i++)
            company.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());

        st.nextToken();
        for(int i = 2; i <= N; i++){
            int manager = Integer.parseInt(st.nextToken());

            company.get(manager).add(i);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int employee = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            scores[employee] += score;

        }

        dfs(1);

        for(int i = 1; i <= N; i++){
            System.out.print(scores[i] + " ");
        }
    }

    public static void dfs(int employee){
        for(int emp : company.get(employee)){
            scores[emp] += scores[employee];
            dfs(emp);
        }
    }
}

//5 4
//-1 1 2 3 4
//2 2
//3 4
//5 6
//3 4