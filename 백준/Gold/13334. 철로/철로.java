import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
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

            if(a < b){
                arr[i][0] = a;
                arr[i][1] = b;
            } else{
                arr[i][0] = b;
                arr[i][1] = a;
            }

        }

        int d = Integer.parseInt(br.readLine());

        Arrays.sort(arr, (o1, o2) -> {
           return o1[1] - o2[1];
        });

        int count = 0;


        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            while(!pq.isEmpty() && pq.peek() < arr[i][1] - d){
                pq.poll();
                count--;
            }
            
            if(arr[i][0] >= arr[i][1] - d){
                count++;
                pq.add(arr[i][0]);
            }
            
            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}
//10
//23 89
//34 41
//2 17
//47 91
//89 98
//85 85
//70 82
//1 3
//48 68
//18 28
//36

//4
//1 4
//1 4
//2 5
//3 4
//3