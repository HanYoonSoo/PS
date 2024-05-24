import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1
 * 0 0 1 0 2
 * 2
 * 0 1 1 0 2
 *
 * 3
 * 0 1 2 0 2
 * -1 0 1 0 2
 *
 * 4
 * -1 0 1 1 3
 *
 * 5
 * -1 0 1 2 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] grand = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            grand[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> rain_area = new HashSet<>();
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            for(int j = start; j <= end; j++){
                grand[j]++;
                rain_area.add(j);
            }

            if(i % 3 == 0){
                for(int area : rain_area.toArray(new Integer[0])){
                    grand[area]--;
                    rain_area = new HashSet<>();
                }
            }
        }

        for(int i = 0; i < N; i++){
            System.out.print(grand[i] + " ");
        }
    }
}
