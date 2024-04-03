import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    static int N;
    static int K;
    static int compare = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        find_K("", 0, 0);

        System.out.println(-1);

    }

    private static void find_K(String result, int count, int total){
        if(total == N) {
            compare++;
            if(compare == K){
                System.out.println(result);
                exit(0);
            }
            return;
        } else if(total > N){
            return;
        }

        for(int i = 1; i <= 3; i++){
            String str = result;
            if(str.length() == 0){
                str += String.valueOf(i);
            }else{
                str += "+"+String.valueOf(i);
            }
            find_K(str, count + 1, total + i);
        }
    }
}
