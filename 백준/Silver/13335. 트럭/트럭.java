import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] road = new int[N];

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> waitQ = new LinkedList<>();
        List<Integer> path = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        if(L == 1){
            System.out.println(N + 1);
            return;
        }


        for(int i = 0; i < L - 1; i++){
            path.add(0);
            q.add(0);
        }

        int sum = 0;

        for(int i = 0; i < N; ){
            if(q.size() < L && sum + road[i] <= W){
                q.add(road[i]);
                path.add(road[i]);
                sum += road[i];
                i++;
            } else{
                q.add(0);
                path.add(0);
            }

            if(q.size() == L){
                int temp = q.poll();

                if(temp != 0){
                    sum -= temp;
                }
            }
        }

        int count = 0;
        if(!q.isEmpty()){
            count = L;
        }

//        System.out.println(path);
        System.out.println(path.size() + count - (L - 1));
    }
}
//4 2 10
//7 4 5 6