import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        if(N == 1){
            System.out.println("A");
        } else if(N == 2){
            if(arr[0] == arr[1])
                System.out.println(arr[0]);
            else
                System.out.println("A");
        } else  if(N > 2){
            int a = 0;
            int b = 0;

            if(arr[0] == arr[1]){
                a = 1;
                b = 0;
            } else{
                a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
                b = arr[1] - arr[0] * a;
            }

            if(check(a, b, arr)){
                System.out.println(arr[N - 1] * a + b);
            } else{
                System.out.println("B");
            }
        }
    }

    public static boolean check(int a, int b, int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i - 1] * a + b)
                return false;
        }

        return true;
    }
}
