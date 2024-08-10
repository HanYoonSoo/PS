import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean real = false;

        for (int i = 0; i < n; i++) {
            int nCall = sc.nextInt();
            sc.nextLine(); // 개행 문자 처리

            String[] cl = new String[nCall];
            for (int j = 0; j < nCall; j++) {
                cl[j] = sc.nextLine().trim();
            }

            Arrays.sort(cl);

            for (int j = 0; j < cl.length - 1; j++) {
                if (cl[j + 1].startsWith(cl[j])) {
                    System.out.println("NO");
                    real = true;
                    break;
                }
            }

            if (!real) {
                System.out.println("YES");
            }
            real = false;
        }

        sc.close();
    }
}
