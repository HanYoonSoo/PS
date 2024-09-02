import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[M];

        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        List<int[]> points = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new int[]{x, y});
        }

        int count = 0;

        for(int i = 0; i < N; i++){
            int left = 0;
            int right = M - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                long dist = Math.abs(arr[mid] - points.get(i)[0]) + points.get(i)[1];

                if(dist <= L){
                    count++;
                    break;
                }

                // 거리가 L보다 큰 경우
                // 1 4 6 9
                if(arr[mid] > points.get(i)[0]){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }
        }

        System.out.println(count);
    }
}
