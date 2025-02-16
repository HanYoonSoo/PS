public class Solution {

    // 분 단위로 변환
    public int convertTime(int n) {
        int h = n / 100;
        int m = n % 100;
        return h * 60 + m;
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int s = startday;
            int schedule = convertTime(schedules[i]);
            boolean isOnTime = true;
            
            for (int j = 0; j < timelogs[i].length; j++) {
                if (s == 6 || s == 7) { // 주말 제외
                    s++;
                    if (s == 8) {  // 일요일 지나면 월요일로
                        s = 1;
                    }
                    continue;
                }
                int t = convertTime(timelogs[i][j]);
                if (schedule + 10 < t) {   // 지각
                    isOnTime = false;
                    break;
                } else {
                    s++;
                }
            }
            
            if (isOnTime) {
                answer++;
            }
        }

        return answer;
    }
}
