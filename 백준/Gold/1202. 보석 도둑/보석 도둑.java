import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> jew = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jew.add(new int[]{M, V});
        }

        int[] bag = new int[K];

        for(int i = 0; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        long total = 0;

        for(int i = 0; i < K; i++){
            int bagW = bag[i];

            while(!jew.isEmpty()){
                if(bagW >= jew.peek()[0]){
                    pq.add(jew.poll()[1]);
                } else{
                    break;
                }
            }

            if(!pq.isEmpty()){
                total += pq.poll();
            }

        }

        System.out.println(total);
    }
}
