import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        for(int i = 0; i < T; i++){
            if(pq.peek() < H || pq.peek() == 1){
                break;
            }
            else if(pq.peek() >= H){
                int num = pq.poll();
                count++;
                num /= 2;
                pq.add(num);
            }
        }

        if(pq.peek() >= H){
            System.out.println("NO");
            System.out.println(pq.peek());
        } else{
            System.out.println("YES");
            System.out.println(count);
        }
    }
}
