
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 모든 사람은 항상 정해진 시간에 싸지방을 이용
    // 컴퓨터는 1번부터 순서대로 번호 지정
    // 모든 사람은 비어있는 자리 중에서 번호가 가장 작은 자리에 앉는 것이 규칙
    // 모든 사람이 기다리지 않고 싸지방을 이용할 수 있는 컴퓨터의 최소 개수와
    // 자리별로 몇 명의 사람이 사용했는가

    // 입력
    /**
     * 5
     * 20 50 2
     * 10 100 1
     * 30 120 3
     * 60 110 2
     * 80 90 4
     */
    public static int N;
    public static PriorityQueue<Node> seats_pq = new PriorityQueue<>(((o1, o2) -> o1.end - o2.end));
    public static PriorityQueue<Node> candidate_pq = new PriorityQueue<>(((o1, o2) -> o1.room - o2.room));
    public static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        count = new int[N];
        List<Node> human_list = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            human_list.add(new Node(start, end));
        }

        Collections.sort(human_list, (o1, o2) -> o1.start - o2.start);

        int idx = 0;

        for(Node curr : human_list){
            while(!seats_pq.isEmpty() && seats_pq.peek().end < curr.start){
                candidate_pq.add(seats_pq.poll());
            }
            int choice_room = candidate_pq.isEmpty() ? idx++ : candidate_pq.poll().room;
            count[choice_room]++;
            curr.room = choice_room;
            seats_pq.add(curr);
        }


        System.out.println(idx);
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0)
                System.out.print(count[i] + " ");
        }
    }
    static class Node{
        int start, end, room;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}

