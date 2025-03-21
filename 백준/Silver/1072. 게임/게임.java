import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int orgWinRate = computeRate(X, Y);

        if(orgWinRate >= 99){
            System.out.println(-1);
            return;
        }

        int left = 1;
        int right = X;

        while(left <= right){
            int mid = (left + right) / 2;

            int changeWinRate = computeRate(X + mid, Y + mid);

            if(changeWinRate > orgWinRate){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    public static int computeRate(int X, int Y){
        return (int)((long)Y * 100 / X);
    }
}
