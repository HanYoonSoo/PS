import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N + 1];

        int lidx = (N % 2 == 1) ? N - 1 : N;
        int cnt = 1;

        for (int i = lidx; i >= 4; i -= 2) {
            a[i] = cnt;
            cnt++;
        }

        a[1] = cnt;
        cnt++;

        for (int i = 2; i <= N; i++) {
            if (a[i] != 0) continue;
            a[i] = cnt;
            cnt++;
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}
