import java.util.*;

class Solution {
    int N;
    int[][] arr;
    boolean[] visited;
    int[] answer;
    double result = 0;

    public int[] solution(int[][] dice) {
        N = dice.length;
        arr = dice;
        visited = new boolean[N];
        answer = new int[N / 2];
        dfs(0, 0);
        return answer;
    }

    public void dfs(int idx, int count) {
        if (count == N / 2) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    bList.add(i);
                } else {
                    aList.add(i);
                }
            }

            // 각 조합에 대한 점수 계산
            HashMap<Integer, Integer> myScoreCnt = calculateScoreCnt(aList);
            HashMap<Integer, Integer> oppScoreCnt = calculateScoreCnt(bList);

            int win = 0, equal = 0, lose = 0;
            for (int m : myScoreCnt.keySet()) {
                for (int o : oppScoreCnt.keySet()) {
                    if (m > o) {
                        win += (myScoreCnt.get(m) * oppScoreCnt.get(o));
                    } else if (m == o) {
                        equal += (myScoreCnt.get(m) * oppScoreCnt.get(o));
                    } else {
                        lose += (myScoreCnt.get(m) * oppScoreCnt.get(o));
                    }
                }
            }

            double ratio = win / (double) (win + equal + lose);

            if (result < ratio) {
                result = ratio;
                for (int i = 0; i < aList.size(); i++) {
                    answer[i] = aList.get(i) + 1; // 인덱스 1 기반으로 반환
                }
            }

            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    // 주사위 조합에 대한 점수 합산
    private HashMap<Integer, Integer> calculateScoreCnt(List<Integer> combination) {
        HashMap<Integer, Integer> scoreCnt = new HashMap<>();
        List<Integer> score = new ArrayList<>();

        for (int i = 0; i < combination.size(); i++) {
            int idx = combination.get(i);

            if (score.size() == 0) {
                // 첫 번째 주사위는 그대로 점수 추가
                for (int j = 0; j < 6; j++) {
                    score.add(arr[idx][j]);
                }
            } else {
                // 이후 주사위는 기존 점수와 더함
                int size = score.size();
                for (int j = 0; j < size; j++) {
                    int s = score.remove(0);
                    for (int k = 0; k < 6; k++) {
                        score.add(arr[idx][k] + s);
                    }
                }
            }
        }

        // 점수 카운트
        for (int s : score) {
            scoreCnt.put(s, scoreCnt.getOrDefault(s, 0) + 1);
        }

        return scoreCnt;
    }
}
