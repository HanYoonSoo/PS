import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

//        Set<Integer> set = new HashSet<>();

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
//        for(int i = 0; i < k; i++){
//            if(count[arr[i]] == 0)
//                max++;
//            count[arr[i]]++;
//        }

        for(int i = 0; i < k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
        }

        max = map.size();

        if(!map.containsKey(c))
            max++;

        for(int i = k; i < N + k; i++){
//            count[arr[(i - k) % N]]--;
//            count[arr[i % N]]++;
            int check = map.get(arr[(i - k) % N]);

            if(check == 1){
                map.remove(arr[(i - k) % N]);
            } else{
                map.put(arr[(i - k) % N], check - 1);
            }

            map.put(arr[i % N], map.getOrDefault(arr[i % N], 0) + 1);

            int temp = map.size();

//            for(int j = 1; j <= d; j++){
//                if(count[j] > 0){
//                    temp++;
//                }
//            }

//            if(count[c] == 0){
//                temp++;
//            }

            if(!map.containsKey(c)){
                temp++;
            }

            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}
