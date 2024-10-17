import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        int maxDay = 0;

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            maxDay = Math.max(d, maxDay);

            pq.add(new int[]{d, w});
        }

        int total = 0;
        
        PriorityQueue<Integer> result = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i = maxDay; i >= 1; i--){
            while(!pq.isEmpty() && pq.peek()[0] >= i){
                result.add(pq.poll()[1]);
            }

            if(!result.isEmpty()){
                total += result.poll();
            }
        }

        System.out.println(total);
    }
}

// 6 5
//

// 1 2 4 5 7