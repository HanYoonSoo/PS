import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 주어진 용액들의 특성값이 [-2, 4, -99, -1, 98]인 경우에는 특성값이 -99인 용액과 특성값이 98인 용액을 혼합하면 특성값이 -1인 용액을 만들 수 있고,
     * 이 용액이 특성값이 0에 가장 가까운 용액이다. 참고로,
     * 두 종류의 알칼리성 용액만으로나 혹은 두 종류의 산성 용액만으로 특성값이 0에 가장 가까운 혼합 용액을 만드는 경우도 존재할 수 있다.
     *
     * 산성 용액과 알칼리성 용액의 특성값이 주어졌을 때,
     * 이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.
     *
     * 입력 예)
     * 5
     * -2 4 -99 -1 98
     *
     * 출력 예)
     * -99 98
     *
     * -99 -2 -1 4 98
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        int p1 = 0;
        int p2 = N - 1;

        int total = 0;
        int min = Integer.MAX_VALUE;

        int p1_num = 0;
        int p2_num = 0;

        while(p1 < p2){
            total = solution[p1] + solution[p2];

            if(min > Math.abs(total)){
                min = Math.abs(total);
                p1_num = solution[p1];
                p2_num = solution[p2];
            }

            if(total == 0){
                System.out.println(p1_num + " " + p2_num);
                return;
            } else if(total < 0){
                p1++;
            } else{
                p2--;
            }
        }
        System.out.println(p1_num + " " + p2_num);
    }

}

/**
 * 5
 *
 * 100 -1 -2 -3 -4
 *
 * /**
 *  * 5
 *  * -2 4 -99 -1 98
 *  * -99 98
 *  *
 *  *
 *  *
 *  * 5
 *  *
 *  * -2 4 -99 -1 99
 *  *
 *  * -99 99
 *  *
 *  * 3
 *  *
 *  * -10 1 2
 *  *
 *  * 1 2
 *  *
 *  *
 *  *
 *  * 4
 *  *
 *  * 999999995 999999996 999999997 1000000000
 *  *
 *  * 999999995 999999996
 *  *
 *  *
 *  *
 *  * 5
 *  *
 *  * -98 -97 1 2 92
 *  *
 *  * 1 2
 *  */


