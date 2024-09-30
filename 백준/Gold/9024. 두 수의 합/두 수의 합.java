import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
//            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int p1 = 0;
            int p2 = N - 1;

            int min = Integer.MAX_VALUE;

//            for(int num : arr){
//                System.out.print(num + " ");
//            }
//            System.out.println();

            while(p1 < p2){
                int compute = Math.abs(K - (arr[p1] + arr[p2]));
//                System.out.print(compute + " ");

                if(compute < min){
                    min = Math.abs(K - (arr[p1] + arr[p2]));

                    count = 1;

//                    System.out.println(map.get(min));

                    if((arr[p1] + arr[p2]) - K < 0){
                        p1++;
                    } else{
                        p2--;
                    }
                } else if(compute == min){
                    count++;

                    if((arr[p1] + arr[p2]) - K < 0){
                        p1++;
                    } else{
                        p2--;
                    }
                }else{
//                    System.out.println(compute + " " + arr[p1] + " " + arr[p2]);
                    if((arr[p1] + arr[p2]) - K < 0){
                        p1++;
                    } else{
                        p2--;
                    }
                }
            }

//            System.out.println(min);
            System.out.println(count);
//            System.out.println("============");
        }
    }
}
