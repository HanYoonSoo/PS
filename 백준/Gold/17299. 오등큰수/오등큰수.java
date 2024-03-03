import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 오등큰수
// 크기가 N인 수열 A = A1, A2, ... , An이 있다고 했을 때
// Ai의 오등큰수는 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수
// 그러한 수가 없을 땐 -1
// A = [1, 1, 2, 3, 4, 2, 1]에서 NGF(1) = -1, NGF(3) = 1, NGF(5), NGF(6) = 1
// 시간복잡도 (O(n^2))
public class Main {
    // 숫자를 카운팅하기 위한 배열
    public static int count[] = new int[1000001];
    // N인 수열의 인덱스를 알기 위한 배열
    public static int index[] = new int[1000001];
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            index[i] = Integer.parseInt(st.nextToken());
            count[index[i]]++;
        }

        int result[] = new int[N+1];

        // stack에는 인덱스가 저장되어 있음
        // 만약 자신의 오른쪽에 있는 값에서 가장 왼쪽값이 자신보다 더 많이 나온 경우
        // 인덱스가 저장되어 있는 stack에서 꺼내 해당 값에 그 값을 넣어줌
        for(int i = 1; i <= N; i++){
            while(!stack.isEmpty() && count[index[stack.peek()]] < count[index[i]]){
                result[stack.pop()] = index[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
