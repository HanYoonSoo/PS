import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{N, 0});

        boolean[] visited = new boolean[100001];
        visited[N] = true;

        int result = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int point = curr[0];
            int time = curr[1];

            if(point == K){
                result = Math.min(result, time);
            }

            if(point * 2 <= 100000 && !visited[point * 2]){
                q.add(new int[]{point * 2, time});
                visited[point * 2] = true;
            }

            if(point - 1 >= 0 && !visited[point - 1]){
                q.add(new int[]{point - 1, time + 1});
                visited[point - 1] = true;
            }
            
            if(point + 1 <= 100000 && !visited[point + 1]){
                q.add(new int[]{point + 1, time + 1});
                visited[point + 1] = true;
            }
            
        }

        System.out.println(result);
    }
}
