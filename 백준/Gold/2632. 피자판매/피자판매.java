import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wanted = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[M];
        int[] B = new int[N];

        int result = 0;

        int aSum = 0;
        for(int i = 0; i < M; i++){
            A[i] = Integer.parseInt(br.readLine());
            aSum += A[i];
        }

        int bSum = 0;
        for(int i = 0; i < N; i++){
            B[i] = Integer.parseInt(br.readLine());
            bSum += B[i];
        }

//        Arrays.sort(A);
//        Arrays.sort(B);

        Map<Integer, Integer> aCount = new HashMap<>();
        aCount.put(aSum, 1);
        Map<Integer, Integer> bCount = new HashMap<>();
        bCount.put(bSum, 1);

        for(int i = 0; i < M; i++){
            int sum = 0;
            for(int j = 0; j < M; j++){
                sum += A[(i + j) % M];
                if(sum != aSum)
                    aCount.put(sum, aCount.getOrDefault(sum, 0) + 1);
            }
        }

        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                sum += B[(i + j) % N];
                if(sum != bSum)
                    bCount.put(sum, bCount.getOrDefault(sum, 0) + 1);
            }
        }


        // A와 B의 부분합을 조합하여 목표값을 찾음
        for (int key : aCount.keySet()) {
            int sub = wanted - key; // 목표값에서 A 부분합을 뺀 값이 B의 부분합에서 존재하는지 확인
//            System.out.println(key + " " + sub);
            if (bCount.containsKey(sub)) {
                result += aCount.get(key) * bCount.get(sub);
//                System.out.println("Count: " + aCount.get(key) + " " + bCount.get(sub));
            }
        }

        // 각각 A나 B에서 목표값을 직접적으로 만들 수 있는 경우도 추가
        if (aCount.containsKey(wanted)) {
            result += aCount.get(wanted);
        }

        if (bCount.containsKey(wanted)) {
            result += bCount.get(wanted);
        }

        System.out.println(result);


    }
}
