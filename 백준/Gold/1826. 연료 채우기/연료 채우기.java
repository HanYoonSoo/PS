import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st;
        int sum = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int count = 0;
        int idx = 0;

        while(P < L){
            while(idx < N && P >= arr[idx][0]){
                pq.add(arr[idx++][1]);
            }

            count++;

            if(!pq.isEmpty())
                P += pq.poll();
            else{
                System.out.println(-1);
                return;
            }
        }

        System.out.println(count);

    }
}

//5
//1 5
//5 7
//6 1
//7 10
//8 3
//20 10

