import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result = 0;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        for (int i = 0; i < num.length(); i++) {
            StringBuilder path = new StringBuilder();
            path.append(num.charAt(i));
            backtracking(i, i, String.valueOf(num.charAt(i)), num, path.toString());
        }

        System.out.println(set.size());
    }

    public static void backtracking(int left, int right, String str, String num, String path) {
        if (left == 0 && right == num.length() - 1) {
            // 경로가 중복되지 않으면 저장
            set.add(path);
            return;
        }

        // 왼쪽에 문자를 추가하는 경우
        if (left > 0) {
            String s = String.valueOf(num.charAt(left - 1));
            backtracking(left - 1, right, s.concat(str), num, path + " " + s.concat(str));
        }

        // 오른쪽에 문자를 추가하는 경우
        if (right + 1 < num.length()) {
            String s = String.valueOf(num.charAt(right + 1));
            backtracking(left, right + 1, str.concat(s), num, path + " " + str.concat(s));
        }
    }
}
