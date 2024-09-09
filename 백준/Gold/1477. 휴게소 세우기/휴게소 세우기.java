import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 2];

        st = new StringTokenizer(br.readLine());


        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        arr[N + 1] = L;
        Arrays.sort(arr);

//        for(int num : arr){
//            System.out.println(num);
//        }

        int left = 1;
        int right = L - 1;

        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;

//            System.out.print(left + " " + right + " " + mid + " ");

//            System.out.print(mid + " ");

            int count = 0;

            for(int i = 1; i <= N + 1; i++){
                count += (arr[i] - arr[i - 1] - 1) / mid;
            }

            if(count > M){
                left = mid + 1;
            } else{
                right = mid - 1;
            }

        }

        System.out.println(left);
    }
}

// 0 200 701 800 1000, mid = 499
// 0 200 701 800 1000 -> count = 1
// 0 200 701 800 1000, mid = 249
// 0 200 701 800 1000 -> count = 2
// 0 200

//6 7 1000
//622 411 201 555 755 82