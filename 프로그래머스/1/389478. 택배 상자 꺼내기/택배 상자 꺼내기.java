class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        while (num <= n) {
            num += 1 + 2 * (w - ((num - 1) % w + 1));
            answer ++;
        }
        return answer;
    }
}