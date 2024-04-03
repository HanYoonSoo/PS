import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 앞당의 길이는 N이고 위치 1부터 위치 N까지만 눈이 쌓여 있음
 * 위치 i에 눈이 a_i만큼 쌓여있음
 * 눈덩이의 시작 크기는 1, 눈덩이의 시작 위치는 0
 * 1. 눈덩이를 현재 위치 +1칸으로 굴림 -> 현재 칸의 위치를 i라고 하면 a_(i+1) 만큼 늘어남
 * 2. 눈덩이를 현재 위치 +2칸으로 던짐. 눈덩이의 크기가 반으로 줄어듬, 현재 칸의 위치를 i라고 하면 눈덩이의 크기는 a_(i+2)만큼 증가
 * 소수점은 절사, 눈덩이가 던져 크기가 0이 눈덩이는 사라지지 않음.
 */
public class Main {

    static int result = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] snow_area = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            snow_area[i] = Integer.parseInt(st.nextToken());
        }

        int snow = 1;

        find_maxSnow(snow, 0, 0, snow_area);

        System.out.println(result);
    }

    private static void find_maxSnow(int snow, int time, int index, int[] snow_area) {
//        System.out.println(snow + " " + time);
        if(time >= M || index >= N){
            result = Math.max(result, snow);
            return;
        }

        snow += snow_area[index + 1];
        find_maxSnow(snow, time + 1, index + 1, snow_area);
        snow -= snow_area[index + 1];

        if((index + 2) <= N)
            find_maxSnow((int) Math.ceil(snow / 2) + snow_area[index + 2], time + 1, index + 2, snow_area);
    }
}
