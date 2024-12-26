import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] lst;
    static boolean[] col;
    static boolean[] up;
    static boolean[] down;
    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lst = new int[n];
        col = new boolean[n + 1];
        up = new boolean[2 * n];
        down = new boolean[2 * n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lst[i] = Integer.parseInt(input[i]);
        }

        Set<Integer> allNumbers = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            allNumbers.add(i);
        }
        for (int num : lst) {
            if (num != 0) allNumbers.remove(num);
        }
        nums = new ArrayList<>(allNumbers);
        Collections.sort(nums);

        if (!backtrack(0)) {
            System.out.println(-1);
        }
    }

    static boolean backtrack(int i) {
        if (i == n) {
            for (int num : lst) {
                System.out.print(num + " ");
            }
            System.out.println();
            return true;
        }

        if (lst[i] != 0) { // Queen already placed
            int num = lst[i];
            if (!col[num] && !up[i - num + n] && !down[i + num]) {
                col[num] = up[i - num + n] = down[i + num] = true;
                if (backtrack(i + 1)) return true;
                col[num] = up[i - num + n] = down[i + num] = false;
            }
            return false;
        }

        for (int num : nums) { // Place a Queen
            if (!col[num] && !up[i - num + n] && !down[i + num]) {
                lst[i] = num;
                col[num] = up[i - num + n] = down[i + num] = true;
                if (backtrack(i + 1)) return true;
                col[num] = up[i - num + n] = down[i + num] = false;
                lst[i] = 0;
            }
        }

        return false;
    }
}
