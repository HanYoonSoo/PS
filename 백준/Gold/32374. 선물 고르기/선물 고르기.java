import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] v = new int[N];
        int[] s = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            v[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        int[] take = new int[K];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++){
            take[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(s);
        Arrays.sort(take);

        int i = N - 1;
        int j = K - 1;

        while(j > 0 && s[i] == take[j]){
            i--;
            j--;
        }

        int box = s[i];

        int max = 0;
        for(i = 0; i < N; i++){
            if(box >= v[i]){
                if(max < v[i]){
                    max = v[i];
                }
            }
        }

        System.out.println(max);
    }
}