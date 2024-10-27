import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] power = new long[N];
        long[] health = new long[N];
        ArrayList<Integer> characters = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            power[i] = Long.parseLong(st.nextToken());
            characters.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            health[i] = Long.parseLong(st.nextToken());
        }

        long pSum = 0;
        int round = 0;

        while (characters.size() > 1) {
            ArrayList<Integer> nextRound = new ArrayList<>();

            for (int i : characters) {
                if (health[i] > pSum - (long) round * power[i]) {
                    pSum += power[i];
                    nextRound.add(i);
                }
            }

            characters = nextRound;
            round++;
        }

        System.out.println(characters.get(0) + 1);
    }
}
