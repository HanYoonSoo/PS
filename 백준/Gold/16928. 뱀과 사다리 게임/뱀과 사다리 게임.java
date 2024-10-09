import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> sadari = new HashMap<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            sadari.put(start, target);
        }

        Map<Integer, Integer> snake = new HashMap<>();

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            snake.put(start, target);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[101];

        q.add(new int[]{1, 0});
        visited[1] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

//            System.out.println(curr[0] + " " + curr[1]);

            if(curr[0] == 100){
                System.out.println(curr[1]);
                break;
            }

            int x = curr[0];
            int count = curr[1];

            for(int i = 1; i <= 6; i++){
                int nx = x + i;

                if(nx <= 100){
                    if(!visited[nx]){
                        if(sadari.containsKey(nx) || snake.containsKey(nx)){
                            if(sadari.containsKey(nx)){
                                q.add(new int[]{sadari.get(nx), count + 1});
                            } else if(snake.containsKey(nx)){
                                q.add(new int[]{snake.get(nx), count + 1});
                            }
                        } else{
                            visited[nx] = true;
                            q.add(new int[]{nx, count + 1});
                        }
                        
                    }
                }
            }
        }
    }
}
