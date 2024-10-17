import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int total = 0;

        int start = arr[0][0];
        int end = arr[0][1];

        for(int i = 1; i < N; i++){
            if(end >= arr[i][0]){
                end = Math.max(arr[i][1], end);
            } else{
                total += end - start;
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        total += (end - start);

        System.out.println(total);
    }
}

//2
//-1000000000 -100
//0 100

//3
//-100 -50
//-80 0
//100 200

//3
//1 4
//2 3
//2 6

