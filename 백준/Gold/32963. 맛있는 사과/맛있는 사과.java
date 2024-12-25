import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int t;
        int s;

        public Node(int t, int s){
            this.t = t;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int t = Integer.parseInt(st1.nextToken());
            int s = Integer.parseInt(st2.nextToken());

            nodes[i] = new Node(t, s);
        }

        Arrays.sort(nodes, (o1, o2) -> o1.t - o2.t);

        StringBuilder sb = new StringBuilder();

        int count = 0;
        int max = 0;
        int[] maxCount = new int[N];

        for(int i = N - 1; i >= 0; i--){
            if(max < nodes[i].s){
                max = nodes[i].s;
                count = 1;
            } else if(max == nodes[i].s){
                count++;
            }

            maxCount[i] = count;
        }

        for(int i = 0; i < Q; i++){
            int p = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                if(nodes[mid].t >= p)
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            if(left >= N){
                sb.append(0).append("\n");
            } else{
                sb.append(maxCount[left]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
