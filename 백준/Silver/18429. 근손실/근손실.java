import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] kit;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        kit = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int muscle = 500;

        fit_check(count, muscle, visited);

        System.out.println(result);
    }

    private static void fit_check(int count, int muscle, boolean[] visited){
        if(muscle < 500){
            return;
        }
        if(count == N){
            result++;
            return;
        }
        for(int i = 0; i < N; i++){
            if(visited[i] == true){
                continue;
            }
            muscle = muscle + kit[i] - K;
            visited[i] = true;
            fit_check(count + 1, muscle, visited);
            visited[i] = false;
            muscle = muscle - kit[i] + K;
        }
    }
}
