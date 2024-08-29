import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String[] str = br.readLine().split("");

            Map<String, Integer> map = new HashMap<>();
            Map<String, Queue<Integer>> indexMap = new HashMap<>();

            List<Integer> result3 = new ArrayList<>();

            int min = Integer.MAX_VALUE;
            int max = 0;

            int K = Integer.parseInt(br.readLine());
            for(int i = 0; i < str.length; i++){
                if(!indexMap.containsKey(str[i])){
                    indexMap.put(str[i], new LinkedList<>());
                    indexMap.get(str[i]).add(i);
                } else{
                    indexMap.get(str[i]).add(i);
                }

                map.put(str[i], map.getOrDefault(str[i], 0) + 1);

                if(map.get(str[i]) >= K){
                    int compute = i - indexMap.get(str[i]).poll() + 1;

                    if(min > compute){
                        min = compute;
                    }

                    if(max < compute){
                        max = compute;
                    }
//                    min = Math.min(compute, min);
//                    max = Math.max(compute, max);
//                    result3.add(i - indexMap.get(str[i]).poll() + 1);
                    map.put(str[i], map.get(str[i]) - 1);
                }
            }

//            if(result3.size() != 0) {
////                Collections.sort(result3);
//                System.out.println(min + " " + max);
//            } else{
//                System.out.println(-1);
//            }

            if(min != Integer.MAX_VALUE && max != 0){
                System.out.println(min + " " + max);
            } else {
                System.out.println(-1);
            }
        }
    }
}