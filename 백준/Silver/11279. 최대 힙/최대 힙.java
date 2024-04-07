import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    /**
     * 단순 힙 구현 문제
     * 이번엔 자바로 구현
     * 자바의 PriorityQueue 활용
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            return o2 - o1;
        }));

        for(int i = 0; i < N; i++){
            int command = scan.nextInt();
            if(command == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                } else{
                    System.out.println(pq.poll());
                }
            } else{
                pq.add(command);
            }
        }
    }
}
