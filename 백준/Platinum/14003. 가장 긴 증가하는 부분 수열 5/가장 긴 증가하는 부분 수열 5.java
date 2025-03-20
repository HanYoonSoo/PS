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

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        List<Integer> idxList = new ArrayList<>();

        int max = 0;

        for(int i = 0; i < N; i++){
            int idx = Collections.binarySearch(list, arr[i]);

            if(idx < 0){
                idx = -idx - 1;
            }

            if(list.size() - 1 < idx){
                list.add(arr[i]);
            } else {
                list.set(idx, arr[i]);
            }
            max = Math.max(idx, max);
            idxList.add(idx);
        }

        List<Integer> result = new ArrayList<>();

        for(int i = idxList.size() - 1; i >= 0; i--){
            if(idxList.get(i) == max){
                result.add(arr[i]);
                max--;
            }
        }

        System.out.println(result.size());
        for(int i = result.size() - 1; i >= 0; i--){
            System.out.print(result.get(i) + " ");
        }
    }
}
