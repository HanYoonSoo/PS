import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * 요세푸스 문제
     * 큐를 사용해서 앞에서 제거함과 동시에 뒤로 넣음
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        int count = 0;

        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        List<String> result = new ArrayList<>();
        while(!q.isEmpty()){
            count++;
            int num = q.poll();

            if(count == K){
                count = 0;
                result.add(String.valueOf(num));
            } else{
                q.add(num);
            }
        }

        String collect = String.join(", ", result);

        System.out.println("<" + collect + ">");
    }
}
