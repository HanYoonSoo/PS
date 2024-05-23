import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static ArrayList<Long> v = new ArrayList<>();
    static ArrayList<Integer> answer = new ArrayList<>();
    static HashMap<Long, Integer> m = new HashMap<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long sum = 0;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(input[i]);
            v.add(num);
            m.put(num, m.getOrDefault(num, 0) + 1);
            sum += num;
        }

        for (int i = 0; i < n; i++) {
            sum -= v.get(i);
            if (sum % 2 == 0) {
                long mid = sum / 2;
                if (m.containsKey(mid)) {
                    if (mid == v.get(i)) {
                        if (m.get(mid) >= 2) {
                            answer.add(i + 1);
                        }
                    } else {
                        answer.add(i + 1);
                    }
                }
            }
            sum += v.get(i);
        }

        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
