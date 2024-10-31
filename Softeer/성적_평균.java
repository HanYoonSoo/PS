import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] score = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            double sum = 0;
            for(int j = a; j <= b; j++){
                sum += score[j];
            }

            sb.append(String.format("%.2f", sum / (b - a + 1))).append("\n");
        }

        System.out.println(sb.toString());
    }
}
