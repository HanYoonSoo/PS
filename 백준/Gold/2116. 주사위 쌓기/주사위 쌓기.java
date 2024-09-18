import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dice = new int[N][6];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int i = 0; i < 6; i++){
            int bottom = dice[0][i];
            int top = dice[0][findTop(i)];

            int sum = findMax(bottom, top);
            for(int j = 1; j < N; j++){
                int max = 0;
                for(int k = 0; k < 6; k++){
                    if(dice[j][k] == top){
                        bottom = top;
                        top = dice[j][findTop(k)];

                        max = findMax(bottom, top);
                        break;
                    }
                }
                sum += max;
            }
            result = Math.max(sum, result);
        }
        System.out.println(result);
    }

    public static int findTop(int idx){
        if(idx == 0) return 5;
        else if(idx == 1) return 3;
        else if(idx == 2) return 4;
        else if(idx == 3) return 1;
        else if(idx == 4) return 2;
        else return 0;
    }

    public static int findMax(int bottom, int top){
        for(int i = 6; i >= 1; i--){
            if(i != bottom && i != top){
                return i;
            }
        }

        return 0;
    }
}
