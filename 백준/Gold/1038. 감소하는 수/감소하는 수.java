import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1, 2, 3, 4, 5, 6, 7, 8, 9            9
 * 10, 20, 21, 30, 31, 32, 40, 41, 42, 43, 50, 51, 52, 53, 54    45
 * 210, 320, 321, 310, 432, 431, 430, 421, 420, 410, 510, 520, 521, 530, 531, 532, 540, 541, 542, 543
 */

// 2 - 1, 3 - 3, 4 - 6, 5 - 10, 6 - 15, 7 - 21, 8 - 28, 9 - 3
// 9 8 7 6 5 4 3 2 1
public class Main {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N <= 10)
            System.out.println(N);
        else if(N > 1022){
            System.out.println(-1);
        }
        else{
            for(int i = 0; i < 10; i++){
                find_num(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }

    private static void find_num(long num, int index) {
        if(index > 10)
            return;

        list.add(num);

        // 9 - 1, 98 - 2, 987 - 3, 9876 - 4, 98765 - 5, 987654 - 6, 9876543 - 7, 98765432 - 8, 987654321 - 9, 9876543210 - 10
        for(int i = 0; i < num % 10; i++){
            find_num((num * 10) + i, index + 1);
        }
    }
}
