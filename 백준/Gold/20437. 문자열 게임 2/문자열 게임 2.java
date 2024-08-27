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
            List<Integer> result4 = new ArrayList<>();

            int K = Integer.parseInt(br.readLine());
            int start = -1;
            for(int i = 0; i < str.length; i++){
                if(!indexMap.containsKey(str[i])){
                    indexMap.put(str[i], new LinkedList<>());
                    indexMap.get(str[i]).add(i);
                } else{
                    indexMap.get(str[i]).add(i);
                }

                map.put(str[i], map.getOrDefault(str[i], 0) + 1);

                if(map.get(str[i]) >= K){
//                    System.out.println(str[i] + " " + i + " " + indexMap.get(str[i]));

//                    if(start == -1){
//                        start = i;
//                    }
//
//                    if(map.get(str[i - K - 1]).equals(str[i])){
//                        result4.add(i - (i - K - 1) + 1);
//                        start++;
//                    }

                    result3.add(i - indexMap.get(str[i]).poll() + 1);
                    map.put(str[i], map.get(str[i]) - 1);
                }
            }

            if(result3.size() != 0) {
                Collections.sort(result3);
//                Collections.sort(result4);
                System.out.println(result3.get(0) + " " + result3.get(result3.size() - 1));
            } else{
                System.out.println(-1);
            }
        }
    }
}
//superaquatornado