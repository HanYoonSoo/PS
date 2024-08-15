import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        Queue<String> q = new LinkedList<>();

        q.add(T);

        while(!q.isEmpty()){
            String str = q.poll();
            if(S.length() > str.length()){
                continue;
            }

//            System.out.println(str);

            if(str.equals(S)){
                System.out.println(1);
                System.exit(0);
            }
            StringBuilder sb = new StringBuilder(str);

            if(sb.charAt(sb.length() - 1) == 'A'){
                q.add(sb.substring(0, sb.length() - 1));
            }

            StringBuilder reverse = sb.reverse();

            if(reverse.charAt(reverse.length() - 1) == 'B'){
                q.add(reverse.substring(0, sb.length() - 1));
            }
        }

        System.out.println(0);
    }
}

//A
//BA <- B를 추가하고 문자열 뒤집기
//BAB <- B를 추가하고 문자열 뒤집기
//BABA <- A를 추가

