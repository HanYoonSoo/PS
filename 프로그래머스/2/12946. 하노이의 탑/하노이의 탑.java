import java.util.*;

class Solution {
    List<int[]> result = new ArrayList<>();

    public int[][] solution(int n) {

        Hanoi(n, 1, 2, 3);

        int[][] answer = result.toArray(new int[0][0]);
        return answer;
    }

    public void Hanoi(int N, int start, int mid, int to){
        if(N == 1){
            result.add(new int[]{start, to});
            return;
        }

        Hanoi(N - 1, start, to, mid);

        result.add(new int[]{start, to});

        Hanoi(N - 1, mid, start, to);
    }
}