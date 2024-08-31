import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int armor = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[i][0] = armor;
            arr[i][1] = weight;
        }

        dfs(0);


        System.out.println(result);
    }

    public static void dfs(int idx){
        if(idx == N){
            int count = 0;
            for(int i = 0; i < N; i++){
                if(arr[i][0] <= 0){
                    count++;
                }
            }

            result = Math.max(result, count);
            return;
        }

        for(int i = 0; i < N; i++){
            if(idx == i){
                continue;
            }

            if(arr[idx][0] > 0 && arr[i][0] > 0){
                arr[idx][0] -= arr[i][1];
                arr[i][0] -= arr[idx][1];
//                System.out.println(idx + ": " + arr[idx][0] + ", " + i + ": " + arr[i][0]);
                dfs(idx + 1);
                arr[idx][0] += arr[i][1];
                arr[i][0] += arr[idx][1];
            } else{
                dfs(idx + 1);
            }
        }
    }
}
