import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int compare = 0;
    static int[] arr;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];

        for(int i = 1; i <= N; i++){
            compare |= 1 << i;
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while(st.hasMoreTokens()){
                arr[i] |= 1 << Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? - 1 : answer);
    }

    public static void dfs(int idx, int count, int number){
        if(number == compare){
            answer = Math.min(answer, count);
            return;
        }

        for(int i = idx; i <= M; i++){
            dfs(i + 1, count + 1, number | arr[i]);
            dfs(i + 1, count, number);
        }
    }

}
