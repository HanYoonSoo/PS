import java.util.StringTokenizer;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] count = new int[100001];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;

        count[arr[0]]++;

        int maxLen = 0;

        while(p1 < N && p2 < N){
            maxLen = Math.max(maxLen, p2 - p1);
            while(p2 + 1 < N && count[arr[p2 + 1]] == K){
                count[arr[p1++]]--;
            }

            if(p2 + 1 < N)
                count[arr[p2 + 1]]++;

            p2++;
        }

        System.out.println(maxLen + 1);
    }
}
