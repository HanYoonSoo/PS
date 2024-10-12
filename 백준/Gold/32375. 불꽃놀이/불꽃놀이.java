import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

//        list.add(K);
        Collections.sort(list);

        int left = 0;
        int right = list.size() - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(list.get(mid) >= K){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        
        long result = list.size() - left;
        
        
        int p1 = 0;
        int p2 = left - 1;
        
        while(p1 < p2){
            if(list.get(p1) + list.get(p2) >= K){
                p1++;
                p2--;
                result++;
            } else{
                p1++;
            }
        }

        System.out.println(result == 0 ? -1 : result);
    }
}
