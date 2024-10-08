import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 14 3
     * 001
     * 101
     * 001
     * 000
     * 111
     * 001
     * 101
     * 111
     * 110
     * 000
     * 111
     * 010
     * 110
     * 001
     * 6
     *
     *
     */
    static String[] grid;
    static int N;
    static int M;
    static int K;
    static int max;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new String[N];
        int[] rampOff = new int[N];

        for(int i = 0; i < N; i++){
            String num = br.readLine();
            for(int j = 0; j < M; j++){
                if(num.charAt(j) == '0'){
                    rampOff[i]++;
                }
                grid[i] = num;
            }
        }

        K = Integer.parseInt(br.readLine());

        int max = 0;

        for(int i = 0; i < N; i++){
            if(rampOff[i] <= K && (K - rampOff[i]) % 2 == 0){
                int count = 1;

                for(int j = 0; j < N; j++){
                    if(i != j){
                        if(grid[i].equals(grid[j])){
                            count++;
                        }
                    }
                }

                max = Math.max(count, max);
            }
        }

        System.out.println(max);
    }

//    public static void dfs(int count){
////        System.out.println(count);
//        if(Math.min(K, max) == count){
//            int cnt = 0;
//            for(int i = 0; i < N; i++){
//                boolean compare = false;
//                for(int j = 0; j < M; j++){
//                    if(grid[i][j] == 0){
//                        compare = true;
//                        break;
//                    }
//                }
//                if(!compare){
//                    cnt++;
//                }
//            }
//
//            result = Math.max(result, cnt);
//
//            return;
//        }
//
//        for(int i = 0; i < M; i++){
//            for(int j = 0; j < N; j++){
//                grid[j][i] = grid[j][i] == 1 ? 0 : 1;
//             }
//            dfs(count + 1);
//            for(int j = 0; j < N; j++){
//                grid[j][i] = grid[j][i] == 1 ? 0 : 1;
//            }
//        }
//    }
}
