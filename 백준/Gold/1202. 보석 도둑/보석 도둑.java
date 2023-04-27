import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        PriorityQueue<int[]> jew = new PriorityQueue<int[]>((a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            else{
                return a[0] - b[0];
            }
        });

        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            jew.add(new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])});
        }

        List<Long> bag = new ArrayList<>();

        for(int i = 0; i < K; i++){
            bag.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(bag);

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        long result = 0;

        for(int i = 0; i < bag.size(); i++){
            long weight = bag.get(i);
            while(!jew.isEmpty()){
                if(weight >= jew.peek()[0]){
                    heap.add(jew.poll()[1]);
                }
                else{
                    break;
                }
            }

            if(!heap.isEmpty()){
                result += heap.poll();
            }
        }

        System.out.println(result);
    }
}
