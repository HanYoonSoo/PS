import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o2.length() - o1.length();
        });

        Set<String> set = new HashSet<>();

        int count = 0;

        for(int i = 0; i < N; i++){
            if(set.isEmpty()){
                set.add(arr[i]);
                count++;
                continue;
            }

            boolean compare = false;
            for(String str : set){
                if(str.indexOf(arr[i]) == 0){
                    compare = true;
                    break;
                }
            }

            if(!compare){
                count++;
                set.add(arr[i]);
            }
        }

        System.out.println(count);
    }
}
