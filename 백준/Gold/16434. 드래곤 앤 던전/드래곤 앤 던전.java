import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int hAttack = Integer.parseInt(st.nextToken());

        long left = 1;
        long right = 0;

        int[][] room = new int[N][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(t == 1){
                right += (long)a * h;
            }

            room[i][0] = t;
            room[i][1] = a;
            room[i][2] = h;
        }

        while(left <= right){
            long mid = (left + right) / 2;
            long hMaxHp = mid;
            long currAttack = hAttack;

//            System.out.println(left + " " + mid + " " + right);
            boolean compare = false;

            for(int i = 0; i < N; i++){
                if(room[i][0] == 1){
                    if(room[i][2] % currAttack == 0){
                        hMaxHp -= (long) room[i][1] * (room[i][2] / currAttack - 1);
                    } else{
                        hMaxHp -= (long) room[i][1] * (room[i][2] / currAttack);
                    }
                } else{
                    currAttack += room[i][1];

                    if(hMaxHp + room[i][2] >= mid){
                        hMaxHp = mid;
                    } else{
                        hMaxHp += room[i][2];
                    }
                }

                if(hMaxHp <= 0){
                    compare = true;
                    break;
                }
            }

            if(compare){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
