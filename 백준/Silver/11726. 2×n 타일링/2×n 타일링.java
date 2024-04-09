import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * DP
     * 단순한 피보나치 류 문제
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> result = new ArrayList<>();

        result.add(0);
        result.add(1);
        result.add(2);

        int N = scan.nextInt();

        if(N < 3){
            System.out.println(N);
            return;
        }

        for(int i = 3; i <= N; i++){
            result.add((result.get(i - 1) + result.get(i - 2)) % 10007);
        }

        System.out.println(result.get(N));
    }
}
