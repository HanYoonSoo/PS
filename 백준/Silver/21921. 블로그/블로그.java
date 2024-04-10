import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 찬솔이는 X일 동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
     *
     * 찬솔이를 대신해서
     * X일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지 구해주자.
     *
     * 첫째 줄에 블로그를 시작하고 지난 일수 N와 X가 공백으로 구분되어 주어진다.
     *
     * 둘째 줄에는 블로그 시작 1일차부터 N일차까지 하루 방문자 수가 공백으로 구분되어 주어진다.
     *
     * 입력 예)
     * 5 2
     * 1 4 2 5 1
     *
     * 출력 예)
     * 7
     * 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visit = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            visit[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;
        int total = 0;

        int count = 0;
        int max = 0;

        while(p1 <= p2 && p1 < N && p2 < N){
            int length = p2 - p1 + 1;
            if(length < K){
                total += visit[p2++];
            } else if(length == K){
                total += visit[p2++];
                if(max < total){
                    max = total;
                    count = 1;
                } else if(max == total){
                    count++;
                }
                total -= visit[p1++];
            }

        }

        if(max == 0){
            System.out.println("SAD");
            return;
        }
        
        System.out.println(max);
        System.out.println(count);
    }
}
