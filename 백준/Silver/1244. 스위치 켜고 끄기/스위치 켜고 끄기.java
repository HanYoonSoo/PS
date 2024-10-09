import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex == 1){
                for(int j = num; j <= N; j += num){
                    arr[j] = arr[j] == 1 ? 0 : 1;
                }
            } else{
                int idx = 0;

                while((num - idx >= 1 && num + idx <= N) && arr[num - idx] == arr[num + idx]){
                    idx++;
                }

//                System.out.println(num + " " + idx);
                idx--;

                for(int j = num - idx; j <= num + idx; j++){
                    arr[j] = arr[j] == 1 ? 0 : 1;
                }
            }

//            for(int j = 1; j <= N; j++){
//                System.out.print(arr[j] + " ");
//            }
        }

        for(int i = 1; i <= N; i++){
            System.out.print(arr[i] + " ");
            if(i % 20 == 0){
                System.out.println();
            }
        }
    }
}
