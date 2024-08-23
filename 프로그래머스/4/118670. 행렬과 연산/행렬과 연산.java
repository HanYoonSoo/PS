import java.util.ArrayDeque;
import java.util.LinkedList;

class Solution {

    int N, M;
    ArrayDeque<Integer> colLeft, colRight;
    LinkedList<ArrayDeque<Integer>> rows;

    public int[][] solution(int[][] rc, String[] operations) {
        init(rc);

        for (String operate : operations) {
            if(operate.equals("Rotate")){
                rotate();
            } else{
                shiftRow();
            }
        }

        int[][] answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            answer[i][0] = colLeft.pollFirst();
            answer[i][M-1] = colRight.pollFirst();
        }

        int idx = 0;

        for (ArrayDeque<Integer> row : rows) {
            for (int j = 1; j < M-1; j++) {
                answer[idx][j] = row.pollFirst();
            }
            idx++;
        }

        return answer;
    }

    public void init(int[][] rc) {
        N = rc.length;
        M = rc[0].length;

        colLeft = new ArrayDeque<>();
        colRight = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            colLeft.add(rc[i][0]);
            colRight.add(rc[i][M-1]);
        }

        rows = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            for (int j = 1; j < M-1; j++) {
                tmp.add(rc[i][j]);
            }
            rows.add(tmp);
        }
    }

    public void rotate() {
        if (M == 2) {
            colRight.addFirst(colLeft.pollFirst());
            colLeft.addLast(colRight.pollLast());
            return;
        }
        rows.peekFirst().addFirst(colLeft.pollFirst());
        colRight.addFirst(rows.peekFirst().pollLast());
        rows.peekLast().addLast(colRight.pollLast());
        colLeft.addLast(rows.peekLast().pollFirst());
    }

    public void shiftRow() {
        rows.addFirst(rows.pollLast());
        colLeft.addFirst(colLeft.pollLast());
        colRight.addFirst(colRight.pollLast());
    }
}