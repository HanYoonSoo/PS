import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10000 이하의 자연수로 이루어진 길이 N짜리 수열
 * 이 수열에서 "연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이"
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] num = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        int end = N;

        int min_len = Integer.MAX_VALUE;
        int compare = 0;
        while (right <= end && left <= end) {
            if(compare >= S && min_len > right - left)
                min_len = right - left;
            else if(compare < S)
                compare += num[right++];
            else
                compare -= num[left++];
        }

        if(min_len == Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(min_len);
        }
    }
}
