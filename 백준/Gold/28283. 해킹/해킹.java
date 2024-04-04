import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 네트워크 안에는 N개의 컴퓨터가 존재(1, 2, 3, ... N)
 * 서로 다른 두 컴퓨터 쌍을 연결하는 M개의 통신
 * i번째 통신망은 S_i번 컴퓨터와 E_i번 컴퓨터를 잇고 있다.
 * 두 컴퓨터 쌍을 연결하는 통신망은 최대 한 개 존재.
 * X개의 컴퓨터 동시 해킹, 해킹 후 1분 뒤 부터 A_i 만큼 돈 갈취
 * 해킹하고 난 후 0.5분부터 B_1, B_2, B_y에 보안 프로그램 설치
 * 해킹/보안 프로그램은 연결된 네트워크 망의 컴퓨터로 전달
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] D = new int[N + 1];

        Arrays.fill(D, -1);

        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < Y; i++){
            int B = Integer.parseInt(st.nextToken());
            q.add(B);
            D[B] = 0;
        }

        while(!q.isEmpty()){
            int B = q.poll();
            for(Integer curr : graph.get(B)){
                if(D[curr] == -1){
                    D[curr] = D[B] + 1;
                    q.add(curr);
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(D[i] == -1 && A[i] != 0){
                System.out.println(-1);
                return;
            }
        }

        long[] result = new long[N + 1];

        for(int i = 1; i <= N; i++){
            result[i] = (long) A[i] * D[i];
        }

        Arrays.sort(result);

        long total = 0;
        for(int i = N; i > N - X; i--){
            total += result[i];
        }

        System.out.println(total);
    }
}
