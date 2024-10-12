import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Character, Integer> sMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        String fullS = br.readLine();

        sMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>();

        int result = 0;
        for(int i = 0; i < W; i++){
            map.put(fullS.charAt(i), map.getOrDefault(fullS.charAt(i), 0) + 1);
        }

        if(compare(map)){
            result++;
        }

//        System.out.println(result);

        for(int i = 1; i < fullS.length() - W + 1; i++){

//            for(Character key : map.keySet()){
//                System.out.println(key + " " + map.get(key));
//            }
//
//            System.out.println("================");

            Character beforeC = fullS.charAt(i - 1);

            map.put(beforeC, Math.max(0, map.get(beforeC) - 1));
//            map.put(fullS.charAt(i), map.getOrDefault(fullS.))

            map.put(fullS.charAt(i + W - 1), map.getOrDefault(fullS.charAt(i + W - 1), 0) + 1);

            if(compare(map)){
//                System.out.println(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean compare(Map<Character, Integer> map){
        for(Character key : sMap.keySet()){
            if(!map.containsKey(key))
                return false;
            else if(!sMap.get(key).equals(map.get(key))){
                return false;
            }
        }

        return true;
    }
}
