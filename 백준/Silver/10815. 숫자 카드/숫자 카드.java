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

        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] findNum = new int[M];

        for(int i = 0; i < M; i++){
            findNum[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < M; i++){
            int left = 0, right = N - 1;
            int mid = 0;
            while(left <= right){
                mid = (left + right) / 2;
                if(num[mid] == findNum[i]){
                    System.out.print("1 ");
                    break;
                }else if(num[mid] < findNum[i]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if(left > right){
                System.out.print("0 ");
            }
        }
    }
}
