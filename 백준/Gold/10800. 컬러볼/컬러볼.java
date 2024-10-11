import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int C;
        int S;
        int idx;

        public Node(int C, int S, int idx){
            this.C = C;
            this.S = S;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int C = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(C, S, i);

        }


        Arrays.sort(nodes, (o1, o2) -> {
            return o1.S - o2.S;
        });

        int[] result = new int[N];
        int[] prefixSum = new int[N + 1];

        int sum = 0;
        int idx = 0;
        for(int i = 0; i < N; i++){
            Node curr = nodes[i];

            while(nodes[idx].S < curr.S){
                sum += nodes[idx].S;
                prefixSum[nodes[idx].C] += nodes[idx].S;
                idx++;
            }

            result[nodes[i].idx] = sum - prefixSum[nodes[i].C];
        }

        StringBuilder sb = new StringBuilder();
        for(int num : result){
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }
}
