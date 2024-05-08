import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] abcd = new int[N][4];

        int[] ab = new int[N * N];
        int[] cd = new int[N * N];

        StringTokenizer st;


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                abcd[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ab[i * N + j] = abcd[i][0] + abcd[j][1];
                cd[i * N + j] = abcd[i][2] + abcd[j][3];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        int p1 = 0;
        int p2 = N * N - 1;

        long result = 0;

        while(p1 < N * N && p2 > -1){
            long abv = ab[p1];
            long cdv = cd[p2];

            long sum = abv + cdv;

            if(sum < 0){
                p1++;
            } else if(sum > 0){
                p2--;
            } else{
                long abCount = 0;
                long cdCount = 0;

                while(p1 < N * N && ab[p1] == abv){
                    abCount++;
                    p1++;
                }

                while(p2 > -1 && cd[p2] == cdv){
                    cdCount++;
                    p2--;
                }

                result += abCount * cdCount;
            }
        }

        System.out.println(result);
    }
}
