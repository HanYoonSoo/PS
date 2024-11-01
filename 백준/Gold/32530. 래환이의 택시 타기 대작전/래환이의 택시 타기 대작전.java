import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N];

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(":");
            int hour = Integer.parseInt(str[0]) * 60;
            int minute = Integer.parseInt(str[1]);

            time[i] = hour + minute;
        }

        Arrays.sort(time);

        int start = time[0];

        int count = 0;

        for(int i = 1; i < N; i++){
            if(start + 10 < time[i]){
                count++;
                start = time[i];
            }
        }

        System.out.println(count + 1);
    }
}
