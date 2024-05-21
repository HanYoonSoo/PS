import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int room1 = Integer.parseInt(st.nextToken());
        int room2 = Integer.parseInt(st.nextToken());
        int room3 = Integer.parseInt(st.nextToken());

        int bed = Integer.parseInt(st.nextToken());

        if(bed % room1 == 0 || bed % room2 == 0 || bed % room3 == 0){
            System.out.println(1);
            return;
        }

        for(int i = 0; i <= bed; i++){
            int studentA = room1 * i;
            for(int j = 0; j <= bed; j++){
                int studentB = room2 * j;
                for(int k = 0; k <= bed; k++){
                    int studentC = room3 * k;

                    if(studentA + studentB + studentC == bed){
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);

    }
}
