import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Car{
        int v;
        int w;
        int number;

        public Car(int v, int w, int number){
            this.v = v;
            this.w = w;
            this.number = number;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Car[] cars = new Car[N];

        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cars[i-1] = new Car(v, w, i);
        }

        Arrays.sort(cars, (c1, c2) -> {
            if(c1.v == c2.v && c1.w == c2.w){
                return -(c1.number - c2.number);
            }
            else if(c1.v == c2.v){
                return -(c1.w - c2.w);
            }

            return -(c1.v - c2.v);
        });

        int sum = 0;

        int compare = -1;

        for(int i = 0; i < N; i++){
            if(compare != cars[i].v){
                sum += cars[i].number;
                compare = cars[i].v;
            }
        }

        System.out.println(sum);
    }
}
