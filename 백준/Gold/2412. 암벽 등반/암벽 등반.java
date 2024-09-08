import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));

        int[] visited = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(arr[i][1] > 2){
                break;
            }

            if(arr[i][0] > 2){
                continue;
            }

            visited[i] = 1;
            q.add(i);
        }

        while(!q.isEmpty()){
            int currIdx = q.poll();

//            System.out.println(arr[currIdx][0] + " " + arr[currIdx][1] + " " + visited[currIdx]);

            if(arr[currIdx][1] == T){
                System.out.println(visited[currIdx]);
                System.exit(0);
            }

            for(int i = currIdx + 1; i < n; i++){
                if(visited[i] == 0){
                    if(arr[i][1] - arr[currIdx][1] > 2){
                        break;
                    }

                    if(Math.abs(arr[i][0] - arr[currIdx][0]) > 2){
                        continue;
                    }

                    visited[i] = visited[currIdx] + 1;
                    q.add(i);
                }
            }

            for(int i = currIdx - 1; i >= 0; i--){
                if(visited[i] == 0){
                    if(arr[i][1] - arr[currIdx][1] < -2){
                        break;
                    }

                    if(Math.abs(arr[i][0] - arr[currIdx][0]) > 2){
                        continue;
                    }

                    visited[i] = visited[currIdx] + 1;
                    q.add(i);
                }
            }
        }

        System.out.println(-1);
    }
}