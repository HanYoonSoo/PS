import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 

        long[] arr = new long[3]; 
        long max = 0; 

        
        for (int i = 0; i < 3; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(arr[i], max); 
        }

        long left = 1;
        long right = max * N; 

        
        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int i = 0; i < 3; i++) {
                count += (mid / arr[i]); 
            }

            if (count >= N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long preCount = 0;
        for (int i = 0; i < 3; i++) {
            preCount += ((left - 1) / arr[i]);
        }

        for (int i = 0; i < 3; i++) {
            if (left % arr[i] == 0) {
                preCount++;
                if (preCount == N) { 
                    if (i == 0) {
                        System.out.println("A win");
                    } else if (i == 1) {
                        System.out.println("B win");
                    } else {
                        System.out.println("C win");
                    }
                    break;
                }
            }
        }
    }
}
