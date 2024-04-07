import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /**
     * 모든 탑은 왼쪽으로 신호를 보냄
     * 또한, 자신보다 높은 탑이 있다면 거기로 신호를 보냄
     * ex) 6 9 5 7 4 -> 0 0 2 2 4
     * solve) 인덱스를 저장하기 위한 배열, 값을 저장하기 위한 배열
     *        왼쪽부터 스택에 쌓으면서 기록
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] index = new int[N + 1];
        int[] top = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            index[i] = i;
            top[index[i]] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= N; i++){
            while(!stack.isEmpty() && top[stack.peek()] <= top[index[i]])
                    stack.pop();

            if(stack.isEmpty()){
                System.out.print("0 ");
            } else if(top[stack.peek()] > top[index[i]]){
                System.out.print(stack.peek() + " ");
            }

            stack.push(index[i]);
        }
    }
}