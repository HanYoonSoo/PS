import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            int N = Integer.parseInt(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < N * 2; j++){
                int num = Integer.parseInt(st.nextToken());

                int compute = (int)(num * 0.75);
                if(map.containsKey(compute)){
                    sb.append(compute).append(" ");

                    if(map.get(compute) == 1){
                        map.remove(compute);
                    } else{
                        map.put(compute, map.get(compute) - 1);
                    }
                } else{
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }

            System.out.println("#"+ i + " " + sb);


        }
    }
}

//2
//3
//15 20 60 75 80 100
//4
//90 90 120 120 120 150 160 200