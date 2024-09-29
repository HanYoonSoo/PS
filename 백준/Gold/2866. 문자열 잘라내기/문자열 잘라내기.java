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

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] arr = new String[R][C];

        for(int i = 0; i < R; i++){
            arr[i] = br.readLine().split("");
        }

        int left = 0;
        int right = R;

        while(left <= right){
            int mid = (left + right) / 2;

            Set<String> set = new HashSet<>();
            boolean compare = false;

            for(int i = 0; i < C; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = mid; j < R; j++){
                    sb.append(arr[j][i]);
                }

                if(set.contains(sb.toString())){
                    compare = true;
                } else{
                    set.add(sb.toString());
                }
            }

            if(!compare){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        System.out.println(left - 1);
    }
}
