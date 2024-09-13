import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        stars = new int[K][2];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars[i][0] = x;
            stars[i][1] = y;
        }

        int result = 0;
        for(int[] star1 : stars){
            for(int[] star2 : stars){
                int temp = computeCount(star1[0], star2[1], L);
                result = Math.max(temp, result);
            }
        }

        System.out.println(K - result);
    }

    public static int computeCount(int x, int y, int L){
        int count = 0;
        for(int[] star : stars){
           if(x <= star[0] && star[0] <= x + L && y <= star[1] && star[1] <= y + L){
               count++;
           }
        }

        return count;
    }
}
