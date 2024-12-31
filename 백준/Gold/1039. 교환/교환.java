import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N < 10 || (N % 10 == 0 && (N / 10) < 10)){
            System.out.println(-1);
            return;
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{N, 0});

        boolean[][] visited = new boolean[1000001][K + 1];
        visited[N][0] = true;

        int max = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int num = curr[0];
            int count = curr[1];

            if(count == K) {
                max = Math.max(max, num);
                continue;
            }

            String strNum = String.valueOf(num);

            for(int i = 0; i < strNum.length(); i++){
                for(int j = i + 1; j < strNum.length(); j++){
                    StringBuilder temp = new StringBuilder(strNum.toString());

                    if(strNum.charAt(j) == '0' && i == 0){
                        continue;
                    }

                    temp.setCharAt(i, strNum.charAt(j));
                    temp.setCharAt(j, strNum.charAt(i));

                    int result = Integer.valueOf(temp.toString());

                    if(!visited[result][count + 1]){
                        visited[result][count + 1] = true;
                        q.add(new int[]{result, count + 1});
                    }
                }
            }
        }

        System.out.println(max);
    }
}

