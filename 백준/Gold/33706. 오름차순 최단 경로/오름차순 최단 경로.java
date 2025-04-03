import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            
            int b = Integer.parseInt(st.nextToken());
            visited[b] = true;
        }

        boolean compare = true;

        for(int i = 2; i <= N; i++){
            if(!visited[i]){
                compare = false;
                break;
            }
        }

        System.out.println(compare ? "YES" : "NO");
    }
}
