import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[1_000_001];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int key : map.keySet()){
            if(key <= 1){
                dp[key] = map.get(key) - 1;
            } else {
                for(int i = 1; i <= Math.sqrt(key); i++){
                    if(key % i == 0){
                        if(map.containsKey(i))
                            dp[key] += map.get(i);
                        if(map.containsKey(key / i)){
                            dp[key] += map.get(key / i);
                            if(key / i == key)
                                dp[key]--;
                            if(key / i == i)
                                dp[key] -= map.get(i);
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            System.out.println(dp[arr[i]]);
        }
    }
}
