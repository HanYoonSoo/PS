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
        int H = Integer.parseInt(st.nextToken());

        int[] up = new int[N / 2];
        int[] down =  new int[N / 2];

        for(int i = 0; i < N / 2; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            up[i] = a;
            down[i] = b;
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = Integer.MAX_VALUE;
        int minCount = 0;

        for(int i = 1; i <= H; i++){
            int countUp = 0;

            int left = 0;
            int right = N / 2 - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                if(up[mid] >= i){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }

            countUp = (N / 2 - 1) - (left - 1);

            left = 0;
            right = N / 2 - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                if(down[mid] >= H - i + 1){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }

            int countDown = (N / 2 - 1) - (left - 1);

            if(min > (countUp + countDown)){
                min = countUp + countDown;
                minCount = 1;
            } else if(min == countUp + countDown){
                minCount++;
            }
        }

        System.out.println(min + " " + minCount);
    }
}
