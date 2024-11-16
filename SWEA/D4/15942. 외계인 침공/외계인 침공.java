import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            TreeMap<Long, Integer> map = new TreeMap<>();

            st = new StringTokenizer(br.readLine());

            long totalCount = 0; // 전체 주민 수 합계를 추적
            for (int i = 0; i < N; i++) {
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
                totalCount += num;
            }

            int dong = 0;

            // 초기 함선이 모든 주민을 동원할 수 없거나, 가장 적은 주민 수보다 작을 경우 종료
            if (K < map.firstKey()) {
                dong = -1;
            } else if (K < totalCount) {
                // 동원이 필요한 경우
                while (totalCount > K && !map.isEmpty()) {
                    Long num = map.floorKey(K);

                    if (num == null) {
                        dong = -1;
                        break;
                    }

                    K += num; 
                    totalCount -= num; 
                    dong++; 

                    int value = map.get(num);
                    if (value == 1) {
                        map.remove(num);
                    } else {
                        map.put(num, value - 1);
                    }
                }
            }

            System.out.println("#" + test_case + " " + dong);
        }
    }
}
