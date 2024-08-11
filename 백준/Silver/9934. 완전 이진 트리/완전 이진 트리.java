import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        String[] tree = br.readLine().split(" ");


        List<String> result = new ArrayList<>();
        int idx;
        for(int N = 0; N < K; N++){
            StringBuilder sb = new StringBuilder();

            int start = (int) (Math.pow(2, N) - 1);

            sb.append(tree[start] + " ");

            idx = start;
            while((idx + (int) Math.pow(2, N + 1)) < tree.length){
                idx += (int) Math.pow(2, (N + 1));
                sb.append(tree[idx] + " ");
            }

            result.add(sb.toString());
        }

        for(int i = result.size() - 1; i >= 0; i--){
            System.out.println(result.get(i));
        }
    }

}
