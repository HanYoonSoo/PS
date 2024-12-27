import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                } else{
                    sb.append(0).append("\n");
                }
            } else{
                pq.add(num);
            }
        }

        System.out.println(sb);
    }
}
