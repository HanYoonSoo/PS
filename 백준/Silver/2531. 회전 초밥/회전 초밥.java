import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

//        Set<Integer> set = new HashSet<>();

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];

        int max = 0;
        for(int i = 0; i < k; i++){
            if(count[arr[i]] == 0)
                max++;
            count[arr[i]]++;
        }

        if(count[c] == 0){
            max++;
        }

        for(int i = k; i < N + k; i++){
            count[arr[(i - k) % N]]--;
            count[arr[i % N]]++;

            int temp = 0;
            for(int j = 1; j <= d; j++){
                if(count[j] > 0){
                    temp++;
                }
            }

            if(count[c] == 0){
                temp++;
            }

            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}
