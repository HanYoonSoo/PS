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
            List<Integer> aSubset = new ArrayList<>();
            List<Integer> bSubset = new ArrayList<>();

            // 방문된 인덱스는 aSubset, 방문되지 않은 인덱스는 bSubset에 추가
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    aSubset.add(i);
                } else {
                    bSubset.add(i);
                }
            }

            // 각 조합에 대한 점수 계산
            Map<Integer, Integer> aScoreMap = calculateScore(aSubset);
            Map<Integer, Integer> bScoreMap = calculateScore(bSubset);

            int win = 0, same = 0, lose = 0;

            // aScoreMap과 bScoreMap을 비교하여 승패 계산
            for (int aKey : aScoreMap.keySet()) {
                for (int bKey : bScoreMap.keySet()) {
                    if (aKey > bKey) {
                        win += (aScoreMap.get(aKey) * bScoreMap.get(bKey));
                    } else if (aKey == bKey) {
                        same += (aScoreMap.get(aKey) * bScoreMap.get(bKey));
                    } else {
                        lose += (aScoreMap.get(aKey) * bScoreMap.get(bKey));
                    }
                }
            }

            // 승리 비율 계산
            double ratio = (double) win / (win + same + lose);

            // 더 나은 비율이 나오면 정답을 갱신
            if (result < ratio) {
                result = ratio;
                for (int i = 0; i < aSubset.size(); i++) {
                    answer[i] = aSubset.get(i) + 1; // 1-based index로 반환
                }
            }

            return;
        }

        // DFS로 조합 탐색
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    // 주사위 조합에 대한 점수 합산
    public Map<Integer, Integer> calculateScore(List<Integer> subSet) {
        List<Integer> scores = new ArrayList<>();

        // 선택된 조합의 점수를 계산
        for (int i = 0; i < subSet.size(); i++) {
            int idx = subSet.get(i);

            if (scores.isEmpty()) {
                // 첫 번째 주사위의 점수는 그대로 추가
                for (int j = 0; j < 6; j++) {
                    scores.add(arr[idx][j]);
                }
            } else {
                // 이후 주사위의 점수를 기존 점수와 더함
                int size = scores.size();
                for (int j = 0; j < size; j++) {
                    int score = scores.remove(0);
                    for (int k = 0; k < 6; k++) {
                        scores.add(arr[idx][k] + score);
                    }
                }
            }
        }

        // 점수를 카운트해서 반환
        Map<Integer, Integer> scoreMap = new HashMap<>();
        for (int score : scores) {
            scoreMap.put(score, scoreMap.getOrDefault(score, 0) + 1);
        }

        return scoreMap;
    }
}
