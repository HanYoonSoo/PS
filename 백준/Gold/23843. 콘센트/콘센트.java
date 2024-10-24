import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> sumpq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < M; i++){
            if(!pq.isEmpty())
                sumpq.add(pq.poll());
        }

        int time = 0;

        int count = 0;
        while(!sumpq.isEmpty()){
            time++;
//            int count = 0;
            while(!sumpq.isEmpty() && time >= sumpq.peek()){
//                count++;
                sumpq.poll();

                if(!pq.isEmpty()) {
                    sumpq.add(time + pq.poll());
                }
//                System.out.println(time);
            }
//            System.out.println(time);
//            System.out.println(pq);
        }

        System.out.println(time);
    }
}

// 5 2
// 1 1 1 4 4 8