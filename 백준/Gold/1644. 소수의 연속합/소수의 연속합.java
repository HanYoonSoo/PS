import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> primeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        if(target <= 1){
            System.out.println(0);
            return;
        }

        primeList.add(2);
        for(int i = 3; i <= target; i += 2){
            if(isPrime(i)){
                primeList.add(i);
//                System.out.println(i);
//                System.out.println(i);
            }
        }


        int p1 = 0;
        int p2 = 0;
        long total = 0;

        int result = 0;

        while (p2 < primeList.size()) {
            if (total >= target) {
                total -= primeList.get(p1++);
//                System.out.print(primeList.get(p1 - 1) + " ");
            } else {
                total += primeList.get(p2++);
//                System.out.print(primeList.get(p2 - 1) + " ");
            }

            if (total == target) {
//                System.out.println(total);
                result++;
            }

//            System.out.println(p1 + " " + p2);

//            System.out.println(total);
        }

        if(isPrime(target))
            result++;
        System.out.println(result);
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num) + 1; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}

