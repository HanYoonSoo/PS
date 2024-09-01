import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //5
    //2 1 5 4 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(arr[num] > 0)
                arr[num]--;

            arr[num - 1]++;
        }

        for(int num : arr){
            result += num;
        }


        System.out.println(result);
    }
}

//8
//5 4 5 4 1 3 3 5

