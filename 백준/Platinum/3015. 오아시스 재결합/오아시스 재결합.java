// 두 사람 A와 B가 서로 볼 수 있으려면, 두 사람 사이에 A 또는 B보다 키가 큰 사람이 없어야 한다.
// 줄에 서있는 사람의 키가 주어졌을 때, 서로 볼 수 있는 쌍의 수를 구하는 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 입력 N(1 <= N <= 500,000) <- O(N^2) <= 시간 복잡도 <= O(NlogN)
// 출력: 서로 볼 수 있는 쌍의 수 출력
public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();

        long result = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            Pair pair = new Pair(num, 1);

            while(!stack.isEmpty() && stack.peek().height <= num){
                Pair pop = stack.pop();
                result += pop.count;

                if(pop.height == num){
                    pair.count += pop.count;
                }
            }
            if(!stack.isEmpty()){
                result++;
            }
            stack.push(pair);
        }

        System.out.println(result);
    }

    static class Pair{
        int height;
        int count;

        public Pair(int height, int count){
            this.height = height;
            this.count = count;
        }
    }
}
