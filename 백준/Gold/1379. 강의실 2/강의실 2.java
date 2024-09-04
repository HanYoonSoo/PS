import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 5
     * 2
     * 5
     * 1
     * 2
     * 4
     * 5
     * 1
     * 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int courseNum = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = courseNum;
            arr[i][1] = start;
            arr[i][2] = end;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[2] - o2[2];
            }
           return o1[1] - o2[1];
        });

//        for(int i = 0; i < N; i++){
//            System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
//        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));

        pq.add(new int[]{arr[0][2], 1});

//        int result = 1;
//        int idx = 1;
//
//        List<Integer> list = new ArrayList<>();
//        Map<Integer, Integer> room = new HashMap<>();
//
//        room.put(arr[0][0], idx);
//
//        Queue<Integer> roomQ = new LinkedList<>();

        int[] result = new int[N];
        result[arr[0][0] - 1] = 1;

        int idx = -1;
        for(int i = 1; i < N; i++){
            int courseNum = arr[i][0];
            int start = arr[i][1];
            int end = arr[i][2];

            boolean check = false;

            idx = -1;

            if(pq.peek()[0] <= start){
                int[] curr = pq.poll();
                check = true;
                idx = curr[1];
            }

            if(!check){
                idx = pq.size() + 1;
            }

            result[courseNum - 1] = idx;
            pq.add(new int[]{end, idx});
        }

        System.out.println(pq.size());

        for(int num : result){
            System.out.println(num);
        }
    }
}
